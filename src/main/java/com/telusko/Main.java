package com.telusko;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       //Student s1= new Student();

       //  INSERT the DATA
//       s1.setsName("Rahul");
//       s1.setRollNo(103);
//       s1.setsAge(32);

       /* Steps
        1> first get the obj of Cofiguration class
        2> use that obj to build a SessionFactory it will return the obj of SessionFactory
        3> using SessionFactory we can create Multiple Sessions


        4> to do above process first we have to build Configuration

        //if you create session we need Factory which is SessionFactory
        //SessionFactory is an interface so we cant create directly its object
        5> before save first Transaction and then commit to save the data in database

        //for create table by hibernate we have to set property in hibernate
          //<property name="hibernate.hbm2ddl.auto">update,create </property>
         */



//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(com.telusko.Student.class);  //it will locate the class
//        cfg.configure();   //it will load the xml file
//
//
//
//        SessionFactory sf = cfg.buildSessionFactory();
//        Session session =sf.openSession();  //openSession() it will create one session
//
//        Transaction transaction= session.beginTransaction();
//        //session.save(s1);
//        session.persist(s1);
//        transaction.commit();
//        sf.close();
//        session.close();
//       System.out.println(s1);

        //  //for FETCH the DATA
//              Student s2= new Student();
//              s2= null;
//              SessionFactory sf = new Configuration()
//                      .addAnnotatedClass(com.telusko.Student.class)
//                      .configure()
//                      .buildSessionFactory();
//              Session session = sf.openSession();
//
//              s2= session.get(Student.class,2);
//              session.close();
//              sf.close();
//        System.out.println(s2);


        //UPDATE the Data in Database

//        Student s1 = new Student();
//        s1.setsName("Rohan");
//        s1.setsAge(26);
//        s1.setRollNo(110);
//
//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(com.telusko.Student.class);
//        cfg.configure();
//
//        SessionFactory sf= cfg.buildSessionFactory();
//        Session session = sf.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.merge(s1);     //merge() will Update in existing table data if there not present then it will insert
//
//        transaction.commit();
//        System.out.println(s1);


        //DELETE the Data in Database
//        s1.setRollNo(110);
//        s1.setsAge(26);
//        s1.setsName("Rohan");

//        SessionFactory sf = new Configuration()
//                .addAnnotatedClass(com.telusko.Student.class)
//                .configure()
//                .buildSessionFactory();
//        Session session= sf.openSession();
//
//       // Transaction transaction= session.beginTransaction();
//
//        //if object is present then simply we can delete it
//        //session.remove(s1);
//
//        //if obj is not present then we can fetch the data by using get() and then delete it by using remove()
//        s1 = session.get(Student.class,101);
//        Transaction transaction= session.beginTransaction();
//        session.remove(s1);
//
//        transaction.commit();
//        System.out.println(s1);
//        session.close();
//        sf.close();


        //creating Laptop Embedded Class object
        Laptop l1 = new Laptop();
        l1.setBrand("HP");
        l1.setModel("Rog");
        l1.setRam(16);
        l1.setLid(1);

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setRam(16);
        l2.setModel("XSP");
        l2.setBrand("DELL");

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setRam(8);
        l3.setModel("XPS");
        l3.setBrand("DELL");

        //Chaning Table
        Alien a1 = new Alien();

        a1.setAid(101);
        a1.setAname("Rohit");
        a1.setTech("Java");


        Alien a2 = new Alien();

        a2.setAid(102);
        a2.setAname("Ritesh");
        a2.setTech("Python");

        Alien a3 = new Alien();

        a3.setAid(103);
        a3.setAname("Rahul");
        a3.setTech("Ruby");

        a1.setLaptops(List.of(l1,l2));
        a2.setLaptops(List.of(l2,l3));
        a3.setLaptops(List.of(l1));

        l1.setAlien(List.of(a1,a3));
        l2.setAlien(List.of(a2,a1));
        l3.setAlien(List.of(a1));



        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.telusko.Alien.class)
                .addAnnotatedClass(com.telusko.Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session= sf.openSession();
        Transaction transaction= session.beginTransaction();
        session.persist(l1);
        session.persist(l2);
        session.persist(l3);
        session.persist(a1);
        session.persist(a2);
        session.persist(a3);


        transaction.commit();
        Alien a5 = session.get(Alien.class,10);
        System.out.println(a2);
        session.close();
        sf.close();



        }

    }