package com.ladiesfirst.butterflyBuissnes.decoder;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SevenSegmentDecoder {

    private Map<List<String>, String> decodeHashMap;

    @PostConstruct
    private void init() {
        List<String> sevenSegments1 = Arrays.asList("", "", "", "", "", "|", "", "", "|");
        List<String> sevenSegments2 = Arrays.asList("", "_", "", "", "_", "|", "|", "_", "");
        List<String> sevenSegments3 = Arrays.asList("", "_", "", "", "_", "|", "", "_", "|");
        List<String> sevenSegments4 = Arrays.asList("", "", "", "|", "_", "|", "", "", "|");
        List<String> sevenSegments5 = Arrays.asList("", "_", "", "|", "_", "", "", "_", "|");
        List<String> sevenSegments6 = Arrays.asList("", "_", "", "|", "_", "", "|", "_", "|");
        List<String> sevenSegments7 = Arrays.asList("", "_", "", "", "", "|", "", "", "|");
        List<String> sevenSegments8 = Arrays.asList("", "_", "", "|", "_", "|", "|", "_", "|");
        List<String> sevenSegments9 = Arrays.asList("", "_", "", "|", "_", "|", "", "_", "|");
        List<String> sevenSegments0 = Arrays.asList("", "_", "", "|", "", "|", "|", "_", "|");
        List<String> sevenSegmentsDash = Arrays.asList("", "", "", "_", "_", "_", "", "", "");
        List<String> sevenSegmentsPoint = Arrays.asList("", "", "", "", "", "", "", ".", "");

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
    }

    public String decode(List<String> list) {
        return decodeHashMap.get(list);
    }

}
