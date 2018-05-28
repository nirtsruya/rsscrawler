package com.nirtsruya.rsscrawler.service;

import com.nirtsruya.rsscrawler.exception.HtmlPostCrawlerException;
import com.nirtsruya.rsscrawler.model.Post;

import java.io.InputStream;

public interface HtmlPostCrawlerService {
    Post crawlPost(final String postLink) throws HtmlPostCrawlerException;
    Post crawlPost(final InputStream inputStream) throws HtmlPostCrawlerException;
}
