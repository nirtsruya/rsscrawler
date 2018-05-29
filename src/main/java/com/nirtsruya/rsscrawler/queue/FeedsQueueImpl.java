package com.nirtsruya.rsscrawler.queue;

import com.nirtsruya.rsscrawler.exception.QueueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class FeedsQueueImpl implements FeedsQueue {

    private final BlockingQueue<String> feeds;

    @Autowired
    public FeedsQueueImpl(){
        feeds = new LinkedBlockingQueue<>();
    }

    @Override
    public boolean addFeed(String url) throws QueueException {
        try {
            feeds.put(url);
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new QueueException("Error inserting to queue", e);
        }
    }

    @Override
    public String takeFeed() throws QueueException {
        try {
            return feeds.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new QueueException("Error taking from queue", e);
        }
    }
}
