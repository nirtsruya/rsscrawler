package com.nirtsruya.rsscrawler.service;

public interface FeedService {
    /**
     * add a feed to the system
     * @param feed url of a feed
     * @return true if successful, otherwise false
     */
    boolean addFeed(final String feed);

    /**
     * get the next feed in the system
     * @return a feed url
     */
    String getFeed();
}
