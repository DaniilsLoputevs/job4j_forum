package ru.job4j.forum.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.ForumApplication;
import ru.job4j.forum.enity.Post;
import ru.job4j.forum.services.PostService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@SpringBootTest(classes = ForumApplication.class)
@AutoConfigureMockMvc
class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PostService postService;

    @Test
    @WithMockUser
    void getPostById() throws Exception {
        Mockito.when(postService.get(-1)).thenReturn(new Post());

        this.mockMvc.perform(get("/post/-1"))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("/post"));
    }

}