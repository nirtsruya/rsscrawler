package com.nirtsruya.rsscrawler.service;

import com.nirtsruya.rsscrawler.model.Post;

import java.util.List;

public interface PostService {
    /**
     * list all crawled posts in the system
     * @return list of posts
     */
    List<Post> listPosts();

    /**
     * add a new post to the system
     * @param post the post
     */
    void addPost(final Post post);
}
