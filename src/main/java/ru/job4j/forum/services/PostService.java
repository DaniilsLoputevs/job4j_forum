package ru.job4j.forum.services;

import org.springframework.stereotype.Service;
import ru.job4j.forum.enity.Post;
import ru.job4j.forum.repositories.PostRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    @PostConstruct
    public void init() {
        this.add(Post.builder().name("О чем этот форум?").build());
        this.add(Post.builder().name("Правила форума.").build());
    }

    public void add(Post post) {
        posts.save(post);
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

}
