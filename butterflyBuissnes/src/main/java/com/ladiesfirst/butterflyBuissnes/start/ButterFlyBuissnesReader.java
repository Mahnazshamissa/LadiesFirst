package com.ladiesfirst.butterflyBuissnes.start;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ButterFlyBuissnesReader {

    @Bean
    public ApplicationRunner inti(ButterFlyExecutor executor) {
        return args -> {
            executor.read();
        };

    }

}
