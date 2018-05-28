package com.nirtsruya.rsscrawler.service;

import com.nirtsruya.rsscrawler.exception.HtmlPostCrawlerException;
import com.nirtsruya.rsscrawler.exception.RSSCrawlerException;
import com.nirtsruya.rsscrawler.model.Post;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class RSSCrawlerServiceImpl implements RSSCrawlerService {

    private final PostService postService;
    private final HtmlPostCrawlerService htmlPostCrawlerService;

    @Autowired
    public RSSCrawlerServiceImpl(final PostService postService,
                                 final HtmlPostCrawlerService htmlPostCrawlerService
    ){
        this.postService = postService;
        this.htmlPostCrawlerService = htmlPostCrawlerService;
    }

    @Override
    public void read(final String url) throws RSSCrawlerException {
        final List<Post> posts = new ArrayList<>();
        try (final XmlReader reader = new XmlReader(new URL(url))) {
            final SyndFeed feed = new SyndFeedInput().build(reader);
            for (final SyndEntry entry : feed.getEntries()) {
                final String postLink = entry.getLink();
                try {
                    final Post post = htmlPostCrawlerService.crawlPost(postLink);
                    postService.addPost(post);
                } catch (final HtmlPostCrawlerException e){
                    System.out.println("Error crawling post " + e.getMessage());
                }
            }
        } catch (MalformedURLException e) {
            throw new RSSCrawlerException("Bad url format", e);
        } catch (IOException e) {
            throw new RSSCrawlerException("Error reading stream", e);
        } catch (FeedException e) {
            throw new RSSCrawlerException("Error creating rss feed", e);
        }
    }
}
