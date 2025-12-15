package com.test.LibaryHibernate;

import java.util.Scanner
;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class App 
{
    public static void main( String[] args )
    {
    	Scanner scan=new Scanner(System.in);
    	System.out.println("Enter name ,price, noofpage");
    	Book book=new Book(scan.next(),scan.nextInt(),scan.nextInt());
    	System.out.println("Enter the name ,gender,age,address");
    	Author author = new Author(scan.next(),scan.next(),scan.nextInt(),scan.next());
    	book.setAuthor(author);
    	
    	SessionFactory factory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction tx = session.beginTransaction();
        
        session.persist(book);
        
        tx.commit();
        
        session.close();
        factory.close();
        scan.close();
    }
}
