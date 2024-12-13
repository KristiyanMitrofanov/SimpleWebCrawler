import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;

public record Crawler(String seedUrl) {

    public void crawl(int level, String url, List<String> visited) {
        if (level <= 5) {
            Document doc = request(url, visited);

            if (doc != null) {
                for (Element link : doc.select("a[href]")) {
                    String nextLink = link.absUrl("href");
                    if (!visited.contains(nextLink)) {
                        crawl(++level, nextLink, visited);
                    }
                }
            }
        }
    }

    private Document request(String url, List<String> visited) {
        try {
            Connection con = Jsoup.connect(url);
            Document doc = con.get();

            if (con.response().statusCode() == 200) {
                System.out.println("Link: " + url);
                System.out.println(doc.title());
                visited.add(url);
                return doc;
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

}


