package ru.job4j.forum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.job4j.forum.enity.Authority;
import ru.job4j.forum.repositories.AuthorityRepository;
import ru.job4j.forum.repositories.UserRepository;

import javax.annotation.PostConstruct;

@Component
public class InitDBState {
    AuthorityRepository authorityRepository;
    UserRepository userRepository;

    @Autowired
    public InitDBState(AuthorityRepository authorityRepository, UserRepository userRepository) {
        this.authorityRepository = authorityRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void initDb() {
        if (!authorityRepository.findAll().iterator().hasNext()) {
            authorityRepository.save(new Authority(0, "ROLE_USER"));
            authorityRepository.save(new Authority(0, "ROLE_ADMIN"));
        }


        /* ### TEMP CODE ### */


//        var rootOpt = userRepository.findById(2);

//        System.err.println("is present: " + rootOpt.isPresent());
//        System.err.println("get: " + rootOpt.get());

//        var root = rootOpt.get();
//        root.setAuthority(authorityRepository.findByAuthority("ROLE_USER"));
//        userRepository.save(root);
    }

}
