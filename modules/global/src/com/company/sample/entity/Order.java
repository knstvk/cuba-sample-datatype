package com.company.sample.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.MetaProperty;

@Table(name = "SAMPLE_ORDER")
@Entity(name = "sample$Order")
public class Order extends StandardEntity {
    private static final long serialVersionUID = 4330171280804494011L;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_")
    protected Date date;

    @MetaProperty(datatype = CurrencyDatatype.NAME)
    @Column(name = "AMOUNT")
    protected BigDecimal amount;

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