import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class spider {
    public static void main(String[] args) throws IOException {

        try {

            Document doc = Jsoup.connect("https://movies.yahoo.com.tw/showtimes").get();
            System.out.println("台北票房TOP10電影");
            System.out.println("==================================");
            //抓取電影的網址位置
            Elements movieUrls = doc.select(".showtime .main-distance .ranking-list li");
            for (Element Urls : movieUrls) {
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
                    System.out.printf("電影中文名稱：%s\n電影英文名稱：%s\n" ,Chinese,English);
                }
               // String URL_1 = "";
               // Element take = doc.select("div.main-distance li a").first();
               // URL_1 = take.attr("href");
               // Document index_1 = Jsoup.connect(URL_1).get();
               // System.out.println(URL_1);
               // System.out.println(index_1.title());

                }
            } catch(Exception e){
                System.out.println("error" + e);
            }
        }
}
