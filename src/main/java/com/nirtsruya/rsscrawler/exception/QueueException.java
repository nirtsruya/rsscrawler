package com.nirtsruya.rsscrawler.exception;

public class QueueException extends Exception {
    public QueueException(final String msg, final Throwable throwable){
        super(msg, throwable);
    }
}
