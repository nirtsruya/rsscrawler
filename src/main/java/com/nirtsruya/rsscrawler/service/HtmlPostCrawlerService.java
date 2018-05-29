package com.nirtsruya.rsscrawler.service;

import com.nirtsruya.rsscrawler.exception.HtmlPostCrawlerException;
import com.nirtsruya.rsscrawler.model.Post;

import java.io.InputStream;

public interface HtmlPostCrawlerService {
    /**
     * crawl a post by opening a connection to URL
     * @param postLink a URL to the post
     * @return the crawled post
     * @throws HtmlPostCrawlerException if an exception occured
     */
    Post crawlPost(final String postLink) throws HtmlPostCrawlerException;

    /**
     * crawl an input stream
     * @param inputStream
     * @return the crawled post
     * @throws HtmlPostCrawlerException if an exception occured
     */
    Post crawlPost(final InputStream inputStream) throws HtmlPostCrawlerException;
}
