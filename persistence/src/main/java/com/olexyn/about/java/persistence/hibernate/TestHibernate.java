package com.olexyn.about.java.persistence.hibernate;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class TestHibernate {

    public static void main(String[] args) {




        Session session = HibernateUtil.getSessionFactory().openSession();

        readCustomers(session);



        CustomerEntity customer = new CustomerEntity();
        customer.setName("Powell");

        session.beginTransaction();
        //Save the Model object
        session.save(customer);

        session.getTransaction().commit();




        readCustomers(session);




        System.out.println("Closing...");
        HibernateUtil.getSessionFactory().close();
    }



    public static void readCustomers(Session session){
        Transaction tx = null;
        try{
            tx = session.beginTransaction();

            Query query = session.createQuery("from CustomerEntity");
            List list = query.list();
            tx.commit();
            int br=0;
        }catch (Throwable t){

        }
        int br=0;
    }

}




