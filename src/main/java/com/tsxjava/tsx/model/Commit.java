package com.tsxjava.tsx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
@Data
@AllArgsConstructor
public class Commit{
    @Value("${github.username}")  // username is in the .env file
    private String username;

    @Value("${github.token}")      // token is in the .env file
    private String token;
}
