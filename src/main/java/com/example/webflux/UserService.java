package com.example.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Ray
 * @date created in 2020/9/30 17:42
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Flux<User> findAllUser() {
        return repository.findAll();
    }

    public Mono<User> findUserByID(Long id) {
        return repository.findById(id);
    }
}
