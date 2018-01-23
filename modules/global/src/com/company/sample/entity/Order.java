package com.company.sample.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "SAMPLE_ORDER")
@Entity(name = "sample$Order")
public class Order extends StandardEntity {
    private static final long serialVersionUID = 4330171280804494011L;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_")
    protected Date date;

    @MetaProperty(datatype = "year")
    @Column(name = "YEAR_")
    protected Integer year;

    @MetaProperty(datatype = "currency")
    @Column(name = "AMOUNT")
    protected BigDecimal amount;

    @MetaProperty(datatype = "interval")
    @Column(name = "EXPIRE_IN")
    protected Integer expireIn;

    public void setExpireIn(Integer expireIn) {
        this.expireIn = expireIn;
    }

    public Integer getExpireIn() {
        return expireIn;
    }


    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getYear() {
        return year;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }


}