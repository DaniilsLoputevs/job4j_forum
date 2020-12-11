package ru.job4j.forum.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.enity.Post;


public interface PostRepository extends CrudRepository<Post, Long> {
}