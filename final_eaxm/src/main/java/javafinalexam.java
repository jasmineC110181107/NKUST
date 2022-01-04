import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class javafinalexam{
    public static void main(String[] args) {
        try {
            Document movie = Jsoup.connect("https://movies.yahoo.com.tw/showtimes").get();//連結到yahoo電影
            System.out.println(movie.title());
            for(int i = 1; i <= 10; i++){//抓第一到第十個項目
                String moviename = movie.select("body > div.showtime > div:nth-child(2) > ul > li:nth-child(" + i + ") > div > div > a:nth-child(1) > h2").text();//抓電影名稱
                System.out.println("第" + i + "名:"+moviename);//名稱前加上第1~10名
            }
        }
        catch (Exception e) {
            System.out.println("error" + e);//顯示錯誤
        }

    }
}