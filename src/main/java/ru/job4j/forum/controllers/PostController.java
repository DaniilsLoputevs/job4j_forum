package ru.job4j.forum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.job4j.forum.services.PostService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PostController {
    private final PostService posts;

    @Autowired
    public PostController(PostService posts) {
        this.posts = posts;
    }

    @GetMapping({"/post/{id}"})
    public String index(Model model, @PathVariable String id) {
        var rsl = posts.get(Integer.parseInt(id));
        var calendar = rsl.getCreated();
        Date time = null;
        if (calendar != null) {
            time = calendar.getTime();
        }

        model.addAttribute("post", rsl);
        model.addAttribute("createdTime",
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(
                        time
                )
        );
        return "/post";
    }

}
