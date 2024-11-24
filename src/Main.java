import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
       Crawler crawler = new Crawler("https://en.wikipedia.org/");
       crawler.crawl(1, crawler.seedUrl(), new ArrayList<>());
    }
}