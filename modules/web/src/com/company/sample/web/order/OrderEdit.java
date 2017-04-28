package com.company.sample.web.order;

import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.sample.entity.Order;
import com.haulmont.cuba.gui.components.TextField;

import javax.inject.Named;
import java.util.Map;

public class OrderEdit extends AbstractEditor<Order> {

    @Named("fieldGroup.expireIn")
    private TextField expireInField;

    @Override
    public void init(Map<String, Object> params) {
        expireInField.setInputPrompt("E.g. 10d 12h 20m 5s");
    }
}