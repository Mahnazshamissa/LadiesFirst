package com.ladiesfirst.butterflyBuissnes.start;

import com.ladiesfirst.butterflyBuissnes.decoder.SevenSegmentDecoder;
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
    final private SevenSegmentDecoder sevenSegmentDecoder;

    public void read() {
        List<String> allRows = fileLoader.asList("buterfly-business.txt");
        List<List<String>> splitedRows = retrieveSplitedRowsFromRawinput(allRows);
        List<String> parsedStrings = parseEachSplitedRowsIntoStrings(splitedRows);
        parsedStrings.forEach(s -> System.out.println(s));
    }

    private List<List<String>> retrieveSplitedRowsFromRawinput(List<String> allRows) {
        return IntStream.range(0, allRows.size())
                .boxed()
                .sorted()
                .filter(i -> i % 3 == 0)
                .map(i -> extractThreeRowsFrom(allRows, i))
                .collect(Collectors.toList());
    }

    private List<String> extractThreeRowsFrom(List<String> allRows, Integer numberPaymentInfo) {
        return Arrays.asList(allRows.get(numberPaymentInfo), allRows.get(numberPaymentInfo + 1), allRows.get(numberPaymentInfo + 2));
    }

    private List<String> parseEachSplitedRowsIntoStrings(List<List<String>> splitedRows) {
        return splitedRows.stream()
                .map(threeLines -> parseThreeLines(threeLines))
                .collect(Collectors.toList());
    }

    private String parseThreeLines(List<String> threeLines) {
        return IntStream.range(0, threeLines.get(0).length())
                .boxed()
                .filter(index -> index % 3 == 0)
                .map(i -> getComposedCharAtIndex(i, threeLines))
                .map(composedChar -> splitUpComposedChar(composedChar))
                .map(composedChar -> retrieveStringFromComposedChar(composedChar))
                .collect(Collectors.joining());
    }

    private List<String> getComposedCharAtIndex(Integer index, List<String> threeLines) {
        return threeLines.stream()
                .map(s -> s.substring(index, index + 3))
                .collect(Collectors.toList());
    }

    private List<List<String>> splitUpComposedChar(List<String> composedChar) {
        return composedChar.stream()
                .map(s -> getCharsFromStringAsStrings(s))
                .collect(Collectors.toList());
    }

    private List<String> getCharsFromStringAsStrings(String input) {
        return input.chars()
                .boxed()
                .map(c -> (char) c.intValue())
                .map(s -> String.valueOf(s))
                .collect(Collectors.toList());
    }

    private String retrieveStringFromComposedChar(List<List<String>> composedChar) {
        return sevenSegmentDecoder.decode(composedChar);
    }

}
