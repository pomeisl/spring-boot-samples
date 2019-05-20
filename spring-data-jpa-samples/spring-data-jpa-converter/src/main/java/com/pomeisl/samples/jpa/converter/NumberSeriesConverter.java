package com.pomeisl.samples.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class NumberSeriesConverter implements AttributeConverter<List<Long>, String> {

    private final static String SEPARATOR = ",";

    @Override
    public String convertToDatabaseColumn(List<Long> attribute) {
        return attribute.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(SEPARATOR));
    }

    @Override
    public List<Long> convertToEntityAttribute(String dbData) {
        return Arrays.stream(dbData.split(SEPARATOR))
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }
}
