package com.company.sample.entity;

import com.google.common.base.Strings;
import com.haulmont.chile.core.annotations.JavaClass;
import com.haulmont.chile.core.datatypes.Datatype;
import com.haulmont.chile.core.datatypes.impl.NumberDatatype;
import org.dom4j.Element;

import javax.annotation.Nullable;
import java.text.ParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@JavaClass(Integer.class)
public class IntervalDatatype extends NumberDatatype implements Datatype<Integer> {

    private static final Pattern PATTERN = Pattern.compile("((\\d{1,})\\s*d)*\\s*((\\d{1,})\\s*h)*\\s*((\\d{1,})\\s*m)*\\s*((\\d{1,})\\s*s)*");

    public IntervalDatatype(Element element) {
        super(element);
    }

    @Override
    public String format(@Nullable Object value) {
        if (value == null)
            return "";

        Integer interval = (Integer) value;
        int days = interval / 86400;
        int hours = (interval - (days * 86400)) / 3600;
        int mins = (interval - (days * 86400) - (hours * 3600)) / 60;
        int secs = interval - (days * 86400) - (hours * 3600) - (mins * 60);

        StringBuilder sb = new StringBuilder();
        if (days != 0)
            sb.append(days).append("d");
        if (hours != 0) {
            if (sb.length() > 0)
                sb.append(" ");
            sb.append(hours).append("h");
        }
        if (mins != 0) {
            if (sb.length() > 0)
                sb.append(" ");
            sb.append(mins).append("m");
        }
        if (secs != 0) {
            if (sb.length() > 0)
                sb.append(" ");
            sb.append(secs).append("s");
        }

        return sb.toString();
    }

    @Override
    public String format(@Nullable Object value, Locale locale) {
        return format(value);
    }

    @Nullable
    @Override
    public Integer parse(@Nullable String value) throws ParseException {
        if (Strings.isNullOrEmpty(value))
            return null;

        int days = 0;
        int hours = 0;
        int mins = 0;
        int secs = 0;
        Matcher matcher = PATTERN.matcher(value);
        if (matcher.find()) {
            if (matcher.group(2) != null) {
                days = Integer.parseInt(matcher.group(2));
            }
            if (matcher.group(4) != null) {
                hours = Integer.parseInt(matcher.group(4));
            }
            if (matcher.group(6) != null) {
                mins = Integer.parseInt(matcher.group(6));
            }
            if (matcher.group(8) != null) {
                secs = Integer.parseInt(matcher.group(8));
            }
        }

        return days * 86400 + hours * 3600 + mins * 60 + secs;
    }

    @Nullable
    @Override
    public Integer parse(@Nullable String value, Locale locale) throws ParseException {
        return parse(value);
    }
}
