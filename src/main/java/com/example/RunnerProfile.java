package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("java25")
public class RunnerProfile implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("JAVA ===> 25 PROFILE");
    }
}
