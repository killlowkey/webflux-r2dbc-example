package com.example.webflux;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ray
 * @date created in 2020/9/30 21:02
 */
@Repository
public interface UserRepository extends R2dbcRepository<User, Long> {
}
