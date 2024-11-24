# SimpleWebCrawler
This is a very simple implementation of a web crawler in Java

# Algorithm
1. We create an object and pass the seedUrl from which we will begin crawling
2. After the crawl begins, we use Jsoup to get the HTML file from the seed URL
3. Then we find all the anchor tags that point to a certain web page and recursively crawl through them
4. We have introduced a 'level' variable in order to track the depth of our recursion. The internet is huge, so we would like to have some kind of restriction in terms of depth.
5. We store each visited URL in a data structure in order to have knowledge about previously visited URLs. This would eliminate duplicate work on the server.

# Jsoup
This projects uses the Jsoup library to help us scrape and parse the HTML from a URL, find the specific links and extract them

