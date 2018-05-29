package com.nirtsruya.rsscrawler.service;

import com.nirtsruya.rsscrawler.exception.QueueException;
import com.nirtsruya.rsscrawler.queue.FeedsQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedServiceImpl implements FeedService{

    private final FeedsQueue feedsQueue;

    @Autowired
    public FeedServiceImpl(final FeedsQueue feedsQueue) {
        this.feedsQueue = feedsQueue;
    }

    @Override
    public boolean addFeed(String feed) {
        try {
            feedsQueue.addFeed(feed);
            return true;
        } catch (final QueueException e) {
            System.out.println("Error adding feed " + e.getMessage());
        }
        return false;
    }

    @Override
    public String getFeed() {
        try {
            return feedsQueue.takeFeed();
        } catch (final QueueException e) {
            System.out.println("Error getting feed " + e.getMessage());
            throw new RuntimeException("Failed to read feed", e);
        }
    }
}
