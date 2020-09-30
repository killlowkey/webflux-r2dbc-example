package com.example.webflux;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author Ray
 * @date created in 2020/9/30 17:43
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 6153736945914863370L;

    @Id
    private Long id;
    private String name;
    private int age;
}
