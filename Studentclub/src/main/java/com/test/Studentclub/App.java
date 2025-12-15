package com.test.Studentclub;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        // Create SessionFactory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        
        Club sports = new Club("Sports");
        Club music = new Club("Music");
        Club coding = new Club("Coding");

        // ---------------- Create Students ----------------
        Student s1 = new Student("Ravi", "ravi@gmail.com");
        Student s2 = new Student("Anu", "anu@gmail.com");

        // ---------------- Assign Clubs to Students ----------------
        Set<Club> raviClubs = new HashSet<>();
        raviClubs.add(sports);
        raviClubs.add(coding);

        Set<Club> anuClubs = new HashSet<>();
        anuClubs.add(music);
        anuClubs.add(coding);

        s1.setClubs(raviClubs);
        s2.setClubs(anuClubs);

        // ---------------- Save Data ----------------
        session.save(sports);
        session.save(music);
        session.save(coding);

        session.save(s1);
        session.save(s2);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("Students and Clubs saved successfully!");
    }
}
