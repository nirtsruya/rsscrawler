package com.nirtsruya.rsscrawler.processor;

import java.util.Set;

public interface RSSCrawlerProcessor {
    void crawl(final Set<String> urls);
}
