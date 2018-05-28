package com.nirtsruya.rsscrawler.repository;

import com.nirtsruya.rsscrawler.model.Post;

import java.util.List;

public interface PostRepository {
    List<Post> list();
    void add(final Post post);
}
