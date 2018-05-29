package com.nirtsruya.rsscrawler.processor;

public interface RSSCrawlerProcessor {
    /**
     * consumes crawl requests from the queue and crawls them
     */
    void crawl();
}
