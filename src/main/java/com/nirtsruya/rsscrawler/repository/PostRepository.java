package com.nirtsruya.rsscrawler.repository;

import com.nirtsruya.rsscrawler.model.Post;

import java.util.List;

public interface PostRepository {
    /**
     * list all posts in the repository
     * @return list of posts
     */
    List<Post> list();

    /**
     * adds a post to the repository
     * @param post the post to add
     */
    void add(final Post post);
}
