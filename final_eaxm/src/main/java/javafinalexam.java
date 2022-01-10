import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class spider {
    public static void main(String[] args) throws IOException {

        try {
            int rank = 1;
            Document doc = Jsoup.connect("https://movies.yahoo.com.tw/showtimes").get();
            System.out.println("台北票房TOP10電影");
            System.out.println("==================================");
            //抓取電影的網址位置
            Elements movieUrls = doc.select(".showtime .main-distance .ranking-list li");
            for (Element Urls : movieUrls) {
                System.out.printf("第%d名\n",rank);
                //抓取各個電影網址
                Element Url = Urls.select(".gabtn").first();
                String movieUrl = Url.absUrl("href");
                //讀取電影資料
                Document movieDoc = Jsoup.connect(movieUrl).get();
                Elements MovieInfos = movieDoc.select("#container #content_l .l_box_inner .table .movie_intro_info_r");
                //讀取並輸出所有資料
                for (Element MovieInfo : MovieInfos){
                    String Chinese = MovieInfo.select("h1").text();
                    String English = MovieInfo.select("h3").text();
                    System.out.printf("電影網址：%s\n" , movieUrl);
                    System.out.printf("電影中文名稱：%s\n電影英文名稱：%s\n" ,Chinese,English);

                }

                rank = rank + 1;
                System.out.println("=============================================================");
                }
            } catch(Exception e){
                System.out.println("error" + e);
            }
        }
}
