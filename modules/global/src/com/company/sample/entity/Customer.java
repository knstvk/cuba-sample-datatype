package com.company.sample.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

@NamePattern("%s|name")
@Table(name = "SAMPLE_CUSTOMER")
@Entity(name = "sample$Customer")
public class Customer extends StandardEntity {
    private static final long serialVersionUID = 315191751275284588L;

    @Column(name = "NAME")
    protected String name;

    @MetaProperty(datatype = "phone")
    @Column(name = "PHONE")
    protected String phone;

    @Column(name = "ACTIVE", columnDefinition = "varchar(10)")
    @Convert(converter = BooleanToYesNoStringConverter.class)
    protected Boolean active;

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getActive() {
        return active;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}