package com.nirtsruya.rsscrawler.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RSSCrawler implements ApplicationListener<ApplicationReadyEvent> {

    private final RSSCrawlerProcessor rssCrawlerProcessor;

    @Autowired
    public RSSCrawler(final RSSCrawlerProcessor rssCrawlerProcessor){
        this.rssCrawlerProcessor = rssCrawlerProcessor;
    }

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        final Set<String> urls = new HashSet<>();
        urls.add("http://rss.cnn.com/rss/edition.rss");
        urls.add("https://www.economist.com/sections/business-finance/rss.xml");
        urls.add("https://www.economist.com/sections/international/rss.xml");
        rssCrawlerProcessor.crawl(urls);
    }
}
