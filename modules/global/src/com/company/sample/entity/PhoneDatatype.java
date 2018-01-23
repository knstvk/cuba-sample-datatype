package com.company.sample.entity;

import com.haulmont.chile.core.annotations.JavaClass;
import com.haulmont.chile.core.datatypes.impl.StringDatatype;

@JavaClass(String.class)
public class PhoneDatatype extends StringDatatype {

    @Override
    public String format(Object value) {
        // input is raw numbers, output +1 2345 6789
        return value == null ? "" : ((String) value).replaceFirst("(\\d+)(\\d{4})(\\d{4})", "+$1 $2 $3");
    }

    @Override
    public String parse(String value) {
        // strip out non-numeric chars
        StringBuilder parsed = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            if (Character.isDigit(value.charAt(i))) {
                parsed.append(value.charAt(i));
            }
        }
        return parsed.toString();
    }
}
