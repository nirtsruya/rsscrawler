package com.nirtsruya.rsscrawler.processor;

import com.nirtsruya.rsscrawler.exception.RSSCrawlerException;
import com.nirtsruya.rsscrawler.service.FeedService;
import com.nirtsruya.rsscrawler.service.RSSCrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class RSSCrawlerProcessorImpl implements RSSCrawlerProcessor {

    private final ExecutorService executor;
    private final RSSCrawlerService rssCrawlerService;
    private final FeedService feedService;

    @Autowired
    public RSSCrawlerProcessorImpl(final RSSCrawlerService rssCrawlerService,
                                   final FeedService feedService){
        this.rssCrawlerService = rssCrawlerService;
        this.executor = Executors.newFixedThreadPool(4);
        this.feedService = feedService;
    }

    @Override
    public void crawl(){
        //sample feed
        feedService.addFeed("http://rss.cnn.com/rss/edition.rss");
        while (true) {
            final String url = feedService.getFeed();
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Started crawling " + url);
                        rssCrawlerService.read(url);
                        System.out.println("Done crawling " + url);
                    } catch (final RSSCrawlerException e) {
                        System.out.println("Error crawling " + e.getMessage());
                    }
                }
            });
        }
    }
}
