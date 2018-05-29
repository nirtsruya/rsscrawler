package com.nirtsruya.rsscrawler.service;

import com.nirtsruya.rsscrawler.exception.RSSCrawlerException;

public interface RSSCrawlerService {
    /**
     * crawls a feed from a url
     * @param url the url of the rss feed
     * @throws RSSCrawlerException if an exception occured
     */
    void read(final String url) throws RSSCrawlerException;
}
