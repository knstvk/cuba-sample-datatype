package com.company.sample.web.customer;

import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.sample.entity.Customer;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;

public class CustomerEdit extends AbstractEditor<Customer> {

    @Inject
    private ComponentsFactory componentsFactory;

    public Component generatePhoneField(Datasource datasource, String fieldId) {
        TextField textField = componentsFactory.createComponent(TextField.class);
        textField.setDatasource(datasource, fieldId);
        return textField;
    }
}