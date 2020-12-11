package ru.job4j.forum.services;

import org.springframework.stereotype.Service;
import ru.job4j.forum.enity.Post;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final List<Post> posts = new ArrayList<>();

    public PostService() {
        posts.add(Post.builder().name("Продаю машину ладу 01.").build());
    }

    public List<Post> getAll() {
        return posts;
    }
}
