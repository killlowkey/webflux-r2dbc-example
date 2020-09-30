package com.example.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

/**
 * @author Ray
 * @date created in 2020/9/30 17:36
 */
@Component
public class UserHandler {

    @Autowired
    private UserService userService;

    public Mono<ServerResponse> getAllUser(ServerRequest request) {
        return userService.findAllUser()
                .reduce(new ArrayList<User>(), (list, user) -> {
                    list.add(user);
                    return list;
                })
                .flatMap(data -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(data))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> findUserById(ServerRequest request) {
        return userService.findUserByID(Long.valueOf(request.pathVariable("id")))
                .flatMap(data -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(data))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

}
