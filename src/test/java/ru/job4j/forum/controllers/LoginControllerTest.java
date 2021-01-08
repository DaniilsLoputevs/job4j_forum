package ru.job4j.forum.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.ForumApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = ForumApplication.class)
@AutoConfigureMockMvc
class LoginControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    void getLoginPage() throws Exception {
        this.mockMvc.perform(get("/login"))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    void getLogoutPage() throws Exception {
        this.mockMvc.perform(get("/logout"))
//                .andDo(print())
                .andExpect(status().isFound())
                .andExpect(header().string("Location", "/login?logout=true"));
    }

}
