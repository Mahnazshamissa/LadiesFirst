package com.ladiesfirst.butterflyBuissnes.start;

import com.ladiesfirst.butterflyBuissnes.dto.Document;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ButterFlyBuissnesReader {

    @Bean
    public ApplicationRunner inti(ButterFlyExecutor executor) {
        return args -> {
            List<Document> documents = executor.readAndParseRows("buterfly-business.txt");
        };
    }

}
