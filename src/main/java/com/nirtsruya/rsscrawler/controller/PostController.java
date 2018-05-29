package com.nirtsruya.rsscrawler.controller;

import com.nirtsruya.rsscrawler.model.Post;
import com.nirtsruya.rsscrawler.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The Posts controller
 */
@RestController
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(final PostService postService){
        this.postService = postService;
    }

    /**
     *
     * @return all posts that were crawled and saved to the system
     */
    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> listPosts(){
        return new ResponseEntity<>(postService.listPosts(), HttpStatus.OK);
    }
}
