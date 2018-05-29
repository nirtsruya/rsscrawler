package com.nirtsruya.rsscrawler.service;

import com.nirtsruya.rsscrawler.exception.HtmlPostCrawlerException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class HtmlPostCrawlerServiceTest {

    @Autowired
    private HtmlPostCrawlerServiceImpl htmlPostCrawlerService;

    @Test(expected = HtmlPostCrawlerException.class)
    public void whenBadURL_ShouldThrowHtmlPostCrawlerException() throws HtmlPostCrawlerException {
        htmlPostCrawlerService.crawlPost("abcd");
    }

    @TestConfiguration
    static class HtmlPostCrawlerServiceTestConfiguration {
        @Bean
        public HtmlPostCrawlerService htmlPostCrawlerService(){
            return new HtmlPostCrawlerServiceImpl();
        }
    }
}
