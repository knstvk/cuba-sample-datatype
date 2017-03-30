package com.company.sample.entity;

import com.haulmont.chile.core.datatypes.impl.StringDatatype;

import javax.annotation.Nonnull;

/**
 *
 */
public class PhoneDatatype extends StringDatatype {

    // This field is required for Studio even if you don't use it in code
    public static final String NAME = "phone";

    @Override
    public String getName() {
        return NAME;
    }

    @Nonnull
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

    @Override
    public String toString() {
        return NAME;
    }
}
