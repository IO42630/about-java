package com.olexyn.about.java.databases.hibernate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;


@Entity
@Table(name = "CUSTOMERS", uniqueConstraints = {@UniqueConstraint(columnNames = "CUSTOMER_ID")})
public class CustomerEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID", unique = true, nullable = false)
    private Integer customerId;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;


    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
