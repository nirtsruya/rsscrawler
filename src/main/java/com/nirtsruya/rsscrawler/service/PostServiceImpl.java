package com.nirtsruya.rsscrawler.service;

import com.nirtsruya.rsscrawler.model.Post;
import com.nirtsruya.rsscrawler.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(final PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> listPosts() {
        return postRepository.list();
    }

    @Override
    public void addPost(final Post post) {
        postRepository.add(post);
    }
}
