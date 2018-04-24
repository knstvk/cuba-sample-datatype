package com.company.sample.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanToYesNoStringConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        if (attribute == null)
            return null;
        return attribute ? "YES" : "NO";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        if (dbData == null)
            return null;
        return "YES".equals(dbData);
    }
}
