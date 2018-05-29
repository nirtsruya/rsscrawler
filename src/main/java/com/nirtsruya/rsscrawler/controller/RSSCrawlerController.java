package com.nirtsruya.rsscrawler.controller;

import com.nirtsruya.rsscrawler.model.CrawlRequest;
import com.nirtsruya.rsscrawler.model.CrawlResponse;
import com.nirtsruya.rsscrawler.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Crawler controller
 *
 */
@RestController
public class RSSCrawlerController {

    private final FeedService feedService;

    @Autowired
    public RSSCrawlerController(final FeedService feedService){
        this.feedService = feedService;
    }

    /**
     * apply an asynchronous crawl request to the application.
     * @param crawlRequest
     * @return a crawl response, containing a unique id for that specific request.
     *  this should allow the user to track the status of the request. (currently not implemented)
     */
    @PostMapping("/crawl")
    public ResponseEntity<CrawlResponse> crawl(final @RequestBody CrawlRequest crawlRequest){
        this.feedService.addFeed(crawlRequest.getUrl());
        return new ResponseEntity<>(new CrawlResponse(), HttpStatus.OK);
    }
}
