package com.olexyn.about.java.databases.hibernate;


import org.hibernate.Session;


public class TestHibernate {

    public static void main(String[] args) {


        //Add new Employee object
        CustomerEntity customer = new CustomerEntity();
        customer.setName("Powell");

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(customer);

        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
    }

}