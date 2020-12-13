package ru.job4j.forum.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.forum.enity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}