package com.nirtsruya.rsscrawler.service;

import com.nirtsruya.rsscrawler.exception.RSSCrawlerException;

public interface RSSCrawlerService {
    void read(final String url) throws RSSCrawlerException;
}
