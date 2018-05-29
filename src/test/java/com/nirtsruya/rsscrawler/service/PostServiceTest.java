package com.nirtsruya.rsscrawler.service;

import com.nirtsruya.rsscrawler.model.Post;
import com.nirtsruya.rsscrawler.repository.PostRepository;
import javafx.geometry.Pos;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostServiceImpl postService;

    private List<Post> mockPosts;
    private Post postMock;

    @Before
    public void before(){
        mockPosts = new ArrayList<>();
        postMock = new Post();
        postMock.setTitle("title");
        mockPosts.add(postMock);
    }

    @Test
    public void whenListPosts_shouldReadFromRepository(){
        when(postRepository.list()).thenReturn(mockPosts);
        final List<Post> posts = postService.listPosts();
        assertNotNull(posts);
        assertEquals(1, posts.size());
        assertEquals("title", posts.get(0).getTitle());
    }

    @Test
    public void whenAddPost_shouldBeAddedToRepository(){
        postService.addPost(postMock);
        verify(postRepository, times(1)).add(postMock);
    }

}
