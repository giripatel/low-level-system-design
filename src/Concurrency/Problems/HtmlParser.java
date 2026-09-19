package Concurrency.Problems;

import java.util.List;

public interface HtmlParser {
    // Return a list of all urls from a webpage of given url.
    // This is a blocking call, that means it will do HTTP request and return when this request is finished.
    List<String> getUrls(String url);
}
