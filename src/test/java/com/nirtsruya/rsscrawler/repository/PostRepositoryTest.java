package com.nirtsruya.rsscrawler.repository;

import com.nirtsruya.rsscrawler.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;

    private Post mockPost;

    @Before
    public void before(){
        mockPost = new Post();
        mockPost.setTitle("title");
    }

    @Test
    public void whenAddPost_shouldBeAvailableInList(){
        postRepository.add(mockPost);
        final List<Post> posts = postRepository.list();
        assertNotNull(posts);
        assertEquals(1, posts.size());
        assertEquals("title", posts.get(0).getTitle());
    }

    @TestConfiguration
    static class PostRepositoryTestConfiguration {
        @Bean
        public PostRepository postRepository(){
            return new PostRepositoryImpl();
        }
    }
}
