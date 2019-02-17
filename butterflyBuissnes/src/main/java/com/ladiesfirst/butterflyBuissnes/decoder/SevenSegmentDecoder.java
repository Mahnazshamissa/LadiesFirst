package com.ladiesfirst.butterflyBuissnes.decoder;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SevenSegmentDecoder {

    private Map<List<List<String>>, String> decodeHashMap;

    @PostConstruct
    private void init() {
        List<List<String>> sevenSegments1 = Arrays.asList(Arrays.asList(" ", " ", " "), Arrays.asList(" ", " ", "|"), Arrays.asList(" ", " ", "|"));
        List<List<String>> sevenSegments2 = Arrays.asList(Arrays.asList(" ", "_", " "), Arrays.asList(" ", "_", "|"), Arrays.asList("|", "_", " "));
        List<List<String>> sevenSegments3 = Arrays.asList(Arrays.asList(" ", "_", " "), Arrays.asList(" ", "_", "|"), Arrays.asList(" ", "_", "|"));
        List<List<String>> sevenSegments4 = Arrays.asList(Arrays.asList(" ", " ", " "), Arrays.asList("|", "_", "|"), Arrays.asList(" ", " ", "|"));
        List<List<String>> sevenSegments5 = Arrays.asList(Arrays.asList(" ", "_", " "), Arrays.asList("|", "_", " "), Arrays.asList(" ", "_", "|"));
        List<List<String>> sevenSegments6 = Arrays.asList(Arrays.asList(" ", "_", " "), Arrays.asList("|", "_", " "), Arrays.asList("|", "_", "|"));
        List<List<String>> sevenSegments7 = Arrays.asList(Arrays.asList(" ", "_", " "), Arrays.asList(" ", " ", "|"), Arrays.asList(" ", " ", "|"));
        List<List<String>> sevenSegments8 = Arrays.asList(Arrays.asList(" ", "_", " "), Arrays.asList("|", "_", "|"), Arrays.asList("|", "_", "|"));
        List<List<String>> sevenSegments9 = Arrays.asList(Arrays.asList(" ", "_", " "), Arrays.asList("|", "_", "|"), Arrays.asList(" ", "_", "|"));
        List<List<String>> sevenSegments0 = Arrays.asList(Arrays.asList(" ", "_", " "), Arrays.asList("|", " ", "|"), Arrays.asList("|", "_", "|"));
        List<List<String>> sevenSegmentsDash = Arrays.asList(Arrays.asList(" ", " ", " "), Arrays.asList("_", "_", "_"), Arrays.asList(" ", " ", " "));
        List<List<String>> sevenSegmentsPoint = Arrays.asList(Arrays.asList(" ", " ", " "), Arrays.asList(" ", " ", " "), Arrays.asList(" ", ".", " "));
        List<List<String>> sevenSegmentsSpace = Arrays.asList(Arrays.asList(" ", " ", " "), Arrays.asList(" ", " ", " "), Arrays.asList(" ", " ", " "));

        decodeHashMap = new HashMap<>();
        decodeHashMap.put(sevenSegments1, "1");
        decodeHashMap.put(sevenSegments2, "2");
        decodeHashMap.put(sevenSegments3, "3");
        decodeHashMap.put(sevenSegments4, "4");
        decodeHashMap.put(sevenSegments5, "5");
        decodeHashMap.put(sevenSegments6, "6");
        decodeHashMap.put(sevenSegments7, "7");
        decodeHashMap.put(sevenSegments8, "8");
        decodeHashMap.put(sevenSegments9, "9");
        decodeHashMap.put(sevenSegments0, "0");
        decodeHashMap.put(sevenSegmentsDash, "_");
        decodeHashMap.put(sevenSegmentsPoint, ".");
        decodeHashMap.put(sevenSegmentsSpace, " ");
    }

    public String decode(List<List<String>> list) {
        return decodeHashMap.get(list);
    }

}
