package ru.job4j.forum.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.forum.enity.Post;
import ru.job4j.forum.repositories.PostRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostConstruct
    public void init() {
        // if store is empty
        if (!postRepository.findAll().iterator().hasNext()) {
            this.save(Post.builder().name("О чем этот форум?").build());
            this.save(Post.builder().name("Правила форума.").build());
        }
    }

    /**
     * add entity, if it is NEW or update, if it exist.
     *
     * @param post entity.
     */
    public void save(Post post) {
        postRepository.save(post);
    }

    public Post get(int id) {
        Optional<Post> rsl = postRepository.findById(id);
        return rsl.orElseGet(Post::new);
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        postRepository.findAll().forEach(rsl::add);
        return rsl;
    }

    public void delete(int id) {
        postRepository.deleteById(id);
    }

}
