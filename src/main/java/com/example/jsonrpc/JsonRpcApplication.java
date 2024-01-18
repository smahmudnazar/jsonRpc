package com.example.jsonrpc;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class JsonRpcApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonRpcApplication.class, args);
    }

}
