package com.nirtsruya.rsscrawler.model;

import java.util.UUID;

public class CrawlResponse {
    /**
     * a unique id for that specific request.
     * this should allow the user to track the status of the request. (currently not implemented)
     */
    private final UUID uuid;

    public CrawlResponse(){
        uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }
}
