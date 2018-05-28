package com.nirtsruya.rsscrawler.service;

import com.nirtsruya.rsscrawler.exception.HtmlPostCrawlerException;
import com.nirtsruya.rsscrawler.model.Post;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class HtmlPostCrawlerServiceImpl implements HtmlPostCrawlerService {
    @Override
    public Post crawlPost(final String postLink) throws HtmlPostCrawlerException {
        URL postURL = null;
        try {
            postURL = new URL(postLink);
        } catch (MalformedURLException e) {
            throw new HtmlPostCrawlerException("Bad url", e);
        }
        try (InputStream inputstream = postURL.openStream()) {
            final Post post = this.crawlPost(inputstream);
            post.setLink(postLink);
            post.setDomain(postURL.getHost());
            return post;
        } catch (IOException e) {
            throw new HtmlPostCrawlerException("Error reading url", e);
        }
    }

    @Override
    public Post crawlPost(final InputStream inputStream) throws HtmlPostCrawlerException {
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        final ParseContext pcontext = new ParseContext();
        final HtmlParser htmlparser = new HtmlParser();
        try {
            htmlparser.parse(inputStream, handler, metadata ,pcontext);
        } catch (IOException e) {
            throw new HtmlPostCrawlerException("Error reading url", e);
        } catch (TikaException e) {
            throw new HtmlPostCrawlerException("Error reading url", e);
        } catch (SAXException e) {
            throw new HtmlPostCrawlerException("Error reading url", e);
        }
        final String author = metadata.get("author");
        final String title = metadata.get("title");
        final String date = metadata.get("date");
        final Post post = new Post();
        post.setTitle(title);
        post.setAuthor(author);
        post.setDate(date);
        return post;
    }
}
