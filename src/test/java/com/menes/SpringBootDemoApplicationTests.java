package com.menes;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.menes.utilities.EmailValidator.isValidEmail;

@SpringBootTest
class SpringBootDemoApplicationTests {


    @Test
    void contextLoads() {
        String email = "test@example.com";
        if (isValidEmail(null)) {
            System.out.println("Valid email");
        } else {
            System.out.println("Invalid email");
        }
    }

}
