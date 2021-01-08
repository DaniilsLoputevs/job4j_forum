package ru.job4j.forum.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
    void postCreateDTOPost() throws Exception {
        var requestDTO = Post.builder()
                .name("Куплю ладу-грант. Дорого. Очень дорого. Ну прям Реально Очень Дорого")
                .desc("На самом деле это \"Aurus Mr. President\"")
                .build();
        this.mockMvc.perform(post("/edit/")
                .param("createdTime","2020-12-14 19:03:00")
                .flashAttr("post", requestDTO))
                .andDo(print())
            .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(postService).save(argument.capture());

        assertEquals("Куплю ладу-грант. Дорого. Очень дорого. Ну прям Реально Очень Дорого",
                argument.getValue().getName());
        assertEquals("На самом деле это \"Aurus Mr. President\"",
                argument.getValue().getDesc());
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