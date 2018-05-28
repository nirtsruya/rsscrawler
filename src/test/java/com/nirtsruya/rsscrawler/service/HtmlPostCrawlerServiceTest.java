package com.nirtsruya.rsscrawler.service;

import com.nirtsruya.rsscrawler.exception.HtmlPostCrawlerException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HtmlPostCrawlerServiceTest {

    @Autowired
    private HtmlPostCrawlerService htmlPostCrawlerService;

    @Test(expected = HtmlPostCrawlerException.class)
    public void whenBadURL_ShouldThrowHtmlPostCrawlerException() throws HtmlPostCrawlerException {
        htmlPostCrawlerService.crawlPost("abcd");
    }
}
