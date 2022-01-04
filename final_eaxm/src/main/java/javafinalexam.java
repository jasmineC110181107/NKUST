import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class javafinalexam{
    public static void main(String[] args) {
        try {
            Document movie = Jsoup.connect("https://movies.yahoo.com.tw/showtimes").get();
            System.out.println(movie.title());
            for(int i = 1; i <= 10; i++){
                String moviename = movie.select("body > div.showtime > div:nth-child(2) > ul > li:nth-child(" + i + ") > div > div > a:nth-child(1) > h2").text();
                System.out.println("第" + i + "名:"+moviename);
            }
        }
        catch (Exception e) {
            System.out.println("error" + e);
        }

    }
}