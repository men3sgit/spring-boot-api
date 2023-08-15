package com.menes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    // return JSON
    @GetMapping("/home")
    public GreetingResponse greet() {
        return new GreetingResponse("Hello World!");
    }

    record GreetingResponse(String mgs) {
    }


}
