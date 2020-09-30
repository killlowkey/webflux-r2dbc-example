package com.example.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author Ray
 * @date created in 2020/9/30 17:33
 */
@Configuration
public class UserRoute {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(UserHandler userHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/users")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), userHandler::getAllUser)
                .andRoute(RequestPredicates.GET("/users/{id}")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), userHandler::findUserById);
    }
}
