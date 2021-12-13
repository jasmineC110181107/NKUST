import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;


//import static org.graalvm.compiler.replacements.Log.log;

public class spider_ptt {
    public  static void main(String[] args){
        try {
         String root_url="https://www.ptt.cc/bbs";
        String check = "";
            String sub_url;
         Document bbs_board_main;
         Map<String, String> cookies=new HashMap<String, String>();

         Document bss_index = Jsoup.connect(root_url).get();
         Elements ptt = bss_index.select("div.b-ent a");

         Element bbs_board_main_CT = root_url.select("div.r-ent div.title a").first();

         for (Element headline : ptt) {
       check = headline.attr("abs:href");

       Response url_check = Jsoup.connect(check).followRedirects(true).execute();

       if (url_check.url().toString().contains("over18"))//如果重新向導至18歲確認
       {
              //送出"我同意"按鈕 並取的cookies
             Connection.Response res = Jsoup
                        .connect(url_check.url().toString())
                   .data("yes", "yes")
                   .method(Connection.Method.POST)
                   .execute();
                 cookies = res.cookies();
                }
            }


        }catch (Exception e){
           System.out.println(e);
        }

    }
}