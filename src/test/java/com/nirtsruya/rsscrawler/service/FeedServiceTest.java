package com.nirtsruya.rsscrawler.service;

import com.nirtsruya.rsscrawler.exception.QueueException;
import com.nirtsruya.rsscrawler.queue.FeedsQueue;
import com.nirtsruya.rsscrawler.queue.FeedsQueueImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class FeedServiceTest {

    @Mock
    private FeedsQueue feedsQueue;

    @InjectMocks
    private FeedServiceImpl feedService;

    @Test(expected = RuntimeException.class)
    public void whenFeedQueueThrowsQueueException_getFeedShouldThrowRuntimeException() throws QueueException {
        Mockito.when(feedsQueue.takeFeed()).thenThrow(QueueException.class);
        feedService.getFeed();
    }

    @Test
    public void whenFeedQueueThrowsQueueException_addFeedShouldReturnFalse() throws QueueException {
        Mockito.when(feedsQueue.addFeed("url")).thenThrow(QueueException.class);
        assertFalse(feedService.addFeed("url"));
    }
}
