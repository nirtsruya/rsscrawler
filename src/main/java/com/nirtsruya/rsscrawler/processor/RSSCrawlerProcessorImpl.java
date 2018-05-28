package com.nirtsruya.rsscrawler.processor;

import com.nirtsruya.rsscrawler.exception.RSSCrawlerException;
import com.nirtsruya.rsscrawler.service.RSSCrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.*;

@Component
public class RSSCrawlerProcessorImpl implements RSSCrawlerProcessor {

    private final ExecutorService executor;
    private final RSSCrawlerService rssCrawlerService;

    @Autowired
    public RSSCrawlerProcessorImpl(final RSSCrawlerService rssCrawlerService){
        this.rssCrawlerService = rssCrawlerService;
        this.executor = Executors.newFixedThreadPool(1);
    }

    @Override
    public void crawl(final Set<String> urls){
        urls.forEach(url -> executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    rssCrawlerService.read(url);
                } catch (final RSSCrawlerException e) {
                    System.out.println("Error crawling " + e.getMessage());
                }
            }
        }));
    }
}
