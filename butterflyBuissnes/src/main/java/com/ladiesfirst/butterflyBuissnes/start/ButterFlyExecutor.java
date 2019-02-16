package com.ladiesfirst.butterflyBuissnes.start;

import com.ladiesfirst.butterflyBuissnes.fileReader.FileLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ButterFlyExecutor {

    private final FileLoader fileLoader;

    public void read() {
        fileLoader.asStream("buterfly-business.txt")
                .forEach(s -> System.out.println(s));
    }

}
