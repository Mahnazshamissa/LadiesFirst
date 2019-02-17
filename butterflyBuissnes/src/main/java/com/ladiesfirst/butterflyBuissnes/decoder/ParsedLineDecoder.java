package com.ladiesfirst.butterflyBuissnes.decoder;

import com.ladiesfirst.butterflyBuissnes.dto.Document;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParsedLineDecoder {

    public List<Document> parseLinesAsDocuments(List<String> input) {
        return input.stream()
                .map(line -> line.split(" "))
                .map(rawData -> parseAsDocument(rawData))
                .collect(Collectors.toList());
    }

    private Document parseAsDocument(String[] rawData) {
        return Document.builder()
                .date(parseDateFromString(rawData[0]))
                .cardNumber(rawData[1])
                .paymentAmount(Double.parseDouble(rawData[2]))
                .build();
    }

    private Date parseDateFromString(String dateStr) {
        String[] split = dateStr.split("_");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        return new Date(year, month, day);
    }

}
