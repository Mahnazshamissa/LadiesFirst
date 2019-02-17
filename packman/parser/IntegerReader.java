package com.ladiesfirst.parser;

import com.ladiesfirst.parser.FileReader;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class IntegerReader {


    private FileReader reader = new FileReader();

    public List<Integer> getInteger() {
        return reader.asStream("level/Levels.txt")
                .map(e->e.replaceAll(" ",""))
                .map(e->e.split(","))
                .flatMap(Stream::of)
                .map(Integer::valueOf)
                .collect(Collectors.toList());


    }



}
