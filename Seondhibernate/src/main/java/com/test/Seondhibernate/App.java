package com.test.Seondhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        
        // 1. Load Hibernate Configuration
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        // 2. Create SessionFactory
        SessionFactory factory = cfg.buildSessionFactory();
        // 3. Open Session
        
        Session session = factory.openSession();
        // Scanner for user input
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student ID to delete: ");
        int id = sc.nextInt();

        // Begin transaction
        Transaction tx = session.beginTransaction();

        try {
            // Fetch the student object from DB
            Student student = session.get(Student.class, id);

            if (student != null) {
                // Delete the object
                session.delete(student);
                tx.commit();
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student with ID " + id + " not found.");
            }

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        // 7. Close Session
        session.close();
        // 8. Close SessionFactory
        factory.close();

        sc.close();
    }
}
