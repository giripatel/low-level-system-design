package Concurrency.Problems;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class WebCrawler {

    private ConcurrentHashMap<String, Boolean> urlHashMap = new ConcurrentHashMap<>();
    private String hostName;
    private AtomicInteger numberOfUrlsToParse = new AtomicInteger(0);
    private ExecutorService executor = Executors.newFixedThreadPool(5);

    private HtmlParser htmlParser;

    class Task implements Runnable {

        private String url;

        public Task(String url) {
            this.url = url;
        }

        @Override
        public void run() {

            for (String extractUrl: htmlParser.getUrls(url)) {

                String extractedHostName = extractUrl.split("/")[2];

                if (hostName.equals(extractedHostName) && !urlHashMap.containsKey(extractUrl)) {
                    urlHashMap.put(extractUrl, true);

                    numberOfUrlsToParse.addAndGet(1);

                    executor.submit(new Task(extractUrl));
                }
            }

            numberOfUrlsToParse.addAndGet(-1);
        }
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {

        this.htmlParser = htmlParser;
        this.hostName = startUrl.split("/")[2];
        urlHashMap.put(startUrl, true);

        numberOfUrlsToParse.addAndGet(1);
        executor.submit(new Task(startUrl));

        if (numberOfUrlsToParse.get() > 0) {
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        executor.shutdown();

        return new ArrayList<>(urlHashMap.keySet());
    }
}
