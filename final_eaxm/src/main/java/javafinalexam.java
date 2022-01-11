import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class spider_work2 {
    public static void main(String[] args) throws IOException {
        try {
            int rank = 1;
            Document doc = Jsoup.connect("https://movies.yahoo.com.tw/showtimes").get();
            System.out.println("台北票房TOP10電影");
            System.out.println("==================================");

            //抓取電影的網址位置
            Elements movieUrls = doc.select(".showtime .main-distance .ranking-list li");
            for (Element Urls : movieUrls){
                //抓取各個電影網址
                Element Url = Urls.select(".gabtn").first();
                String movieUrl = Url.absUrl("href");
                //讀取電影資料
                Document movieDoc = Jsoup.connect(movieUrl).get();
                //抓取電影詳細資料的位置
                Elements MovieInfos = movieDoc.select("#container #content_l .l_box_inner .table .movie_intro_info_r");
                //讀取並輸出所有資料
                for (Element MovieInfo : MovieInfos){
                    System.out.printf("第%d名\n",rank);
                    //抓取電影名稱
                    String Chinese = MovieInfo.select("h1").text();  //抓取電影中文名稱
                    String English = MovieInfo.select("h3").text();  //抓取電影英文名稱
                    System.out.printf("電影網址：%s\n" , movieUrl);
                    System.out.printf("電影中文名稱：%s\n電影英文名稱：%s\n" ,Chinese,English);
                    //抓取電影類別
                    Elements levelName = MovieInfo.select(".level_name");
                    System.out.println("電影類別：" + levelName.text());
                    //抓取並輸出上映日期至分數資料
                    Elements intro = MovieInfos.select("span");
                    for (int i = 0 ; i <= intro.size() - 3 ; i++){
                        System.out.println(intro.get(i).text());
                    }
                    //抓取並輸出導演與演員資料
                    for (int i = intro.size() - 2 ; i <= intro.size() - 1 ; i ++){
                        System.out.println("...............................");
                        System.out.println(intro.get(i).text());
                        if (intro.get(i).text().contains("導演")){
                            Element director = MovieInfo.select(".movie_intro_list").get(0);
                            System.out.println(director.text());
                        }else{
                            Element director = MovieInfo.select(".movie_intro_list").get(1);
                            String actorList = director.text();
                            actorList = actorList.replace(" 、 ","\n");
                            System.out.println(actorList);
                        }
                    }
                    rank = rank + 1;
                    System.out.println("=============================================================");
                }
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }
}
