package ru.job4j.forum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.aop.Log;
import ru.job4j.forum.enity.Post;
import ru.job4j.forum.services.PostService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
public class EditController {
    private final PostService postService;
    private final SimpleDateFormat simpleDateFormat;

    @Autowired
    public EditController(PostService postService, SimpleDateFormat simpleDateFormat) {
        this.postService = postService;
        this.simpleDateFormat = simpleDateFormat;
    }

    @GetMapping({"/edit/{id}"})
    @Log
    public String getEditDTOPostById(Model model, @PathVariable String id) {
        var post = postService.get(Integer.parseInt(id));
        var calendar = post.getCreated();
        String time = null;

        if (calendar != null) {
            time = simpleDateFormat.format(calendar.getTime());
        }

        model.addAttribute("id", id);
        model.addAttribute("post", post);
        model.addAttribute("createdTime", time);
        return "/edit";
    }

    @PostMapping({"/edit/"})
    @Log
    public String postCreateDTOPost(@ModelAttribute Post post,
                                    @RequestParam("createdTime") String createdTime)
            throws ParseException {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(simpleDateFormat.parse(createdTime));

        post.setCreated(calendar);
        postService.save(post);
        return "redirect:/";
    }

    @GetMapping({"/edit-del/{id}"})
    @Log
    public String getEditDelById(@PathVariable String id) {
        postService.delete(Integer.parseInt(id));
        return "redirect:/";
    }

}
