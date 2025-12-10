package com.test.HibernateMaven;

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
        System.out.println("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Student Mark: ");
        int mark = sc.nextInt();
        sc.nextLine(); 
        System.out.println("Enter Student Email: ");
        String email = sc.nextLine();

        // Create Student object
        Student student = new Student(name, mark, email);

        // 4. Begin Transaction
        Transaction tx = session.beginTransaction();
        try {
            // 5. Perform CRUD Operation → SAVE student
            session.save(student);
            // 6. Commit Transaction
            tx.commit();
            System.out.println("Student saved successfully!");
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
