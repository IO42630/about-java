package com.olexyn.about.java.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)


@XmlRootElement(name = "ClassToMarshal")
public class ClassToMarshal {

    @XmlAttribute
    private int foo = 1;


    public void setFoo(int foo) {
        this.foo = foo;
    }

    public int getFoo() {
        return foo;
    }

    public void modifyFoo(){ this.foo++;}
}
