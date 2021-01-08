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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = ForumApplication.class)
@AutoConfigureMockMvc
class EditControllerTest {

    @MockBean
    private PostService postService;
    @Autowired
    private MockMvc mockMvc;


    @Test
    @WithMockUser
    void getEditDTOPostById() throws Exception {
        Mockito.when(postService.get(-1)).thenReturn(new Post());

        this.mockMvc.perform(get("/edit/-1"))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("/edit"));
    }

    @Test
    @WithMockUser
    void getEditDelById() throws Exception {

        this.mockMvc.perform(get("/edit-del/-1"))
//                .andDo(print())
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/"));
    }

}