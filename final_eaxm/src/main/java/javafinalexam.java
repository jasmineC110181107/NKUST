import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class spider_work2 {
    public static void main(String[] args) throws IOException {
        try {
            Document doc = Jsoup.connect("https://movies.yahoo.com.tw/showtimes").get();
            System.out.println("台北票房TOP10電影");
            System.out.println("==================================");
            for (int i = 1; i <= 10; i++) {
                String MovieName = doc.select("body > div.showtime > div:nth-child(2) > ul > li:nth-child(" + i + ") > div > div > a:nth-child(1) > h2").text();
                String EnglishName = doc.select("body > div.showtime > div:nth-child(2) > ul > li:nth-child(" + i + ") > div > div > a:nth-child(1) > h3").text();
                System.out.println("第" + i + "名 : " + MovieName + "\n" + "英文名稱 : " + EnglishName);

 //.....................................................................................................................................................
                Elements take = doc.select("showtime > main-distance > ranking-list > li > href");
                System.out.print(take);
                String take1 = doc.select("main-distance").text();
                String take2 = doc.select("span").get(4).text();
                String take3 = doc.select("span").get(5).text();
                String take4 = doc.select("span").get(6).text();
                String take5 = doc.select("span").get(7).text();
                String take6 = doc.select("span").get(8).text();
                System.out.println("類別 : " + take1 + "\n" + "上映日期 : " + take2 + "\n" + "片長 : " + take3 + "\n" + "發行公司 : " + take4 + "\n" + "IMDb分數 : " + take5 + "\n" + "導演 : " + take6 + "\n");
              
                //把這坨丟進裡面標題可以顯示，剩下內容  :))  
//......................................................................................................................................................
                
                System.out.println("==================================");

            }

                //String take = doc.select("showtime > main-distance > ranking-list > li > href").text();
                //System.out.print(take);   // .......這個搞不定


            //for (int a = 0; a < 5; a++) {   //.........我在想這個是否需要
               // String take1 = doc.select("main-distance").text();
               // String take2 = doc.select("span").get(0).text();
               // String take3 = doc.select("span").get(1).text();
               // String take4 = doc.select("span").get(2).text();
               // String take5 = doc.select("span").get(3).text();
               // String take6 = doc.select("span").get(4).text();

                //System.out.println("類別 : " + take1 + "\n" + "評分 : " + take2 + "\n" + "代號 : " + take3 + "\n" + "上映日期 : " + take4 + "\n" + "片長 : " + take5 + "\n" + "導演 : " + take6 + "\n");
                // }

        } catch (Exception e) {
            System.out.println("error" + e);
        }

    }
}
