package com.company.sample.entity;

import com.google.common.base.Strings;
import com.haulmont.chile.core.annotations.JavaClass;
import com.haulmont.chile.core.datatypes.Datatype;
import com.haulmont.chile.core.datatypes.impl.NumberDatatype;
import org.dom4j.Element;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;

@JavaClass(BigDecimal.class)
public class CurrencyDatatype extends NumberDatatype implements Datatype<BigDecimal> {

    private static final String PATTERN = "$#,##0.00";

    public CurrencyDatatype(Element element) {
        super(element);
    }

    @Override
    public String format(@Nullable Object value) {
        if (value == null)
            return "";

        DecimalFormat format = new DecimalFormat(PATTERN);
        return format.format(value);
    }

    @Override
    public String format(@Nullable Object value, Locale locale) {
        return format(value);
    }

    @Nullable
    @Override
    public BigDecimal parse(@Nullable String value) throws ParseException {
        if (Strings.isNullOrEmpty(value))
            return null;

        DecimalFormat format = new DecimalFormat(PATTERN);
        format.setParseBigDecimal(true);
        BigDecimal result;
        try {
            result = (BigDecimal) format.parse(value);
        } catch (ParseException e) {
            try {
                result = new BigDecimal(value);
            } catch (Exception e1) {
                throw new ParseException("Error parsing " + value, 0);
            }
        }
        return result;
    }

    @Nullable
    @Override
    public BigDecimal parse(@Nullable String value, Locale locale) throws ParseException {
        return parse(value);
    }
}
