package ru.job4j.forum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.aop.Log;
import ru.job4j.forum.enity.User;
import ru.job4j.forum.repositories.AuthorityRepository;
import ru.job4j.forum.repositories.UserRepository;


@Controller
public class RegController {
    private PasswordEncoder encoder;
    private UserRepository users;
    private AuthorityRepository authorities;

    public RegController() {
    }

    @Autowired
    public RegController(PasswordEncoder encoder,
                         UserRepository users, AuthorityRepository authorities) {
        this.encoder = encoder;
        this.users = users;
        this.authorities = authorities;
    }

    @PostMapping("/reg")
    @Log
    public String save(@ModelAttribute User user) {
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorities.findByAuthority("ROLE_USER"));
        users.save(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    @Log
    public String reg() {
        return "reg";
    }

}
