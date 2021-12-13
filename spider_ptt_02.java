import java.util.HashMap;
import java.util.Map;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class spider_ptt_02 {
    public static void main(String[] args) {
        try {
            String root_url="https://www.ptt.cc/bbs";
            String root_url_nobbs ="https://www.ptt.cc/";
            String sub_url;
            Document bbs_board_main;
            Document bbs_board_sub;
            String before_check="";
            Map<String, String> cookies=new HashMap<String, String>();

            Document bss_index = Jsoup.connect(root_url).get();   //取的BBS index(主頁) 內容
            Elements bbs_boards = bss_index.select("div.b-ent a");//取的BBS 每個熱門看板 內容
            for (Element line : bbs_boards) {
                before_check = line.attr("abs:href");  //取的BBS 每個熱門看板 網址
                //取的進入BBS看板重新導向網址
                Response url_check = Jsoup.connect(before_check).followRedirects(true).execute();

                if (url_check.url().toString().contains("over18"))//如果重新向導至18歲確認
                {
                    //送出"我同意"按鈕 並取的cookies
                    Response res = Jsoup
                            .connect(url_check.url().toString())
                            .data("yes", "yes")
                            .method(Connection.Method.POST)
                            .execute();
                    cookies = res.cookies();
                }
                //用cookies取得網頁資料
                bbs_board_main = Jsoup.connect(before_check).cookies(cookies).get();

                //抓取第一篇
                Element bbs_board_main_CT = bbs_board_main.select("div.r-ent div.title a").first();
                //抓取第一篇的標題和URL
                String bbs_board_main_CT_title= bbs_board_main_CT.text();
                String bbs_board_main_CT_url= bbs_board_main_CT.attr("href");
                sub_url=root_url_nobbs + bbs_board_main_CT_url;

                //印出標題及網址
                System.out.println("" +bbs_board_main.title() + " " + sub_url);
                System.out.println(bbs_board_main_CT_title);

                //抓取第一篇內文
                bbs_board_sub = Jsoup.connect(sub_url).cookies(cookies).get();
                //抓取並印出第一篇內文的留言(push)
                String push="";
                try {
                    //取第一個使用者
                    Element bbs_sub_push = bbs_board_sub.select("div.push span[class=f3 hl push-userid]").first();
                    push += bbs_sub_push.text();
                    //取第一個留言內容
                    bbs_sub_push = bbs_board_sub.select("div.push span[class=f3 push-content]").first();
                    push = push + bbs_sub_push.text();
                    System.out.println("==>"+push);
                }catch (Exception e){
                    System.out.println("==>無留言");
                }
                System.out.println();

            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

}