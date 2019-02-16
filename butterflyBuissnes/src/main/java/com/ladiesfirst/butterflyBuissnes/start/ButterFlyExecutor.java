package com.ladiesfirst.butterflyBuissnes.start;

import com.ladiesfirst.butterflyBuissnes.fileReader.FileLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class ButterFlyExecutor {

    private final FileLoader fileLoader;

    public void read() {
        List<String> allRows = fileLoader.asList("buterfly-business.txt");
        List<List<String>> splitedRows = IntStream.range(0, allRows.size())
                .boxed()
                .filter(i -> i % 3 == 0)
                .map(i -> extractThreeRowsFrom(allRows, i))
                .collect(Collectors.toList());
    }

    private List<String> extractThreeRowsFrom(List<String> allRows, Integer i) {
        return Arrays.asList(allRows.get(i), allRows.get(i + 1), allRows.get(i + 2));
    }



}
