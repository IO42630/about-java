package com.olexyn.java.about.spring.boot.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FRUIT")
public class FruitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* Let the DB manage the PK. */
    private Long pk;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COLOR")
    private String color;

    public Long getPk() {
        return pk;
    }

    public void setPk(Long id) {
        this.pk = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
