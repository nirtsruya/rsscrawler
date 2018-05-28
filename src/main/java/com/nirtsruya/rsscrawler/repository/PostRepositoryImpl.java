package com.nirtsruya.rsscrawler.repository;

import com.nirtsruya.rsscrawler.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private final List<Post> posts = new ArrayList<>();

    @Override
    public List<Post> list() {
        return posts;
    }

    @Override
    public void add(Post post) {
        posts.add(post);
    }
}
