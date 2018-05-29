package com.nirtsruya.rsscrawler.queue;

import com.nirtsruya.rsscrawler.exception.QueueException;

public interface FeedsQueue {
    /**
     * add a feed to the queue
     * @param url url of the feed
     * @throws QueueException if an exception occured
     */
    void addFeed(final String url) throws QueueException;

    /**
     *
     * @return the next feed to crawl
     * @throws QueueException if an exception occured
     */
    String takeFeed() throws QueueException;
}
