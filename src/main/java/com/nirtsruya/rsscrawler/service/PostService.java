package com.nirtsruya.rsscrawler.service;

import com.nirtsruya.rsscrawler.model.Post;

import java.util.List;

public interface PostService {
    List<Post> listPosts();
    void addPost(final Post post);
}
