package com.test.Thirdhibernate;

/**
 * Hello world!
 *
 */
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App{

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //config hibernate and load session factory 
        SessionFactory factory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        System.out.println("Enter id of a student to update name and email: ");
        int id = scan.nextInt();

        Student obj = session.get(Student.class, id);

        if (obj != null) {
            System.out.println("Enter new name:");
            String name = scan.next();

            System.out.println("Enter new email:");
            String email = scan.next();

            obj.setName(name);
            obj.setEmail(email);

            session.persist(obj);  

            System.out.println("Updated Successfully!");
        } else {
            System.out.println("Student with id " + id + " not found!");
        }

        transaction.commit();
        session.close();
        factory.close();
        scan.close();
    }
}
