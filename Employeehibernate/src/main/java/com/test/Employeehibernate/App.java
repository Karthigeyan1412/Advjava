package com.test.Employeehibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class App 
{
    public static void main( String[] args )
    {
       Scanner scan=new Scanner(System.in);
       
       SessionFactory factory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
       
       while (true) {
           System.out.println("1. Add Employee");
           System.out.println("2. Get Employee by ID");
           System.out.println("3. Update Employee ");
           System.out.println("4. Delete Employee");
           System.out.println("other . Exit");
           System.out.print("Enter choice: ");
           
           int choice = scan.nextInt();
           
           switch (choice){
           case 1:
        	   addEmployee(factory, scan);
               break;
           case 2:
        	   getEmployee(factory, scan);
               break;
           case 3:
        	   updateEmployee(factory, scan);
               break;   
           case 4:
        	   DeleteEmployee(factory, scan);
               break;
           default:
               factory.close();
               scan.close();
               System.out.println("Thankyou for using the employee management ");
           }
       
       }}
    public static void addEmployee(SessionFactory factory, Scanner scan) {
        System.out.print("Enter Name: ");
        String name = scan.next();
        
        System.out.print("Enter Email: ");
        String email = scan.next();
        
        System.out.print("Enter Salary: ");
        int salary = scan.nextInt();
        
        Employee emp = new Employee(name, email, salary);
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(emp);
        
        tx.commit();
        
        session.close();
        System.out.println("Employee Added Successfully!");
    }
    public static void getEmployee(SessionFactory factory, Scanner scan) {
        System.out.print("Enter Employee ID: ");
        int id = scan.nextInt();

        Session session = factory.openSession();
        Employee emp = session.get(Employee.class, id);

        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println("Employee Not Found!");
        }

        session.close();
    }
    public static void DeleteEmployee(SessionFactory factory, Scanner scan) {
    	System.out.println("Enter Employee Id: ");
    	int id = scan.nextInt();
    	
    	Session session =factory.openSession();
    	Employee emp = session.get(Employee.class,id);
    	
    	if(emp == null) {
    		System.out.println("Employee not found!");
    		session.close();
    		return;	
    	}
    	Transaction tx = session.beginTransaction();
    	session.delete(emp);
    	tx.commit();
    	session.close();
    	
    	System.out.println("employee deleted successfully");
    }
    public static void updateEmployee(SessionFactory factory, Scanner scan) {
        System.out.print("Enter Employee ID to Update: ");
        int id = scan.nextInt();
        
        Session session = factory.openSession();
        Employee emp = session.get(Employee.class, id);

        if (emp == null) {
            System.out.println("Employee Not Found!");
            session.close();
            return;
        }

        System.out.println(" What do you want to update?");
        System.out.println("A → Update Name");
        System.out.println("B → Update Salary");
        System.out.println("C → Update Email");
        System.out.print("Enter choice: ");
        
        char choice = scan.next().toUpperCase().charAt(0);
        Transaction tx = session.beginTransaction();

        switch (choice) {

            case 'A':
                System.out.print("Enter New Name: ");
                String newName = scan.next();
                emp.setName(newName);
                break;

            case 'B':
                System.out.print("Enter New Salary: ");
                int newSalary = scan.nextInt();
                emp.setSalary(newSalary);
                break;

            case 'C':
                System.out.print("Enter New Email: ");
                String newEmail = scan.next();
                emp.setEmail(newEmail);
                break;

            default:
                System.out.println("Invalid Choice!");
                session.close();
                return;
        }
        
        session.update(emp);
        tx.commit();
        session.close();
        
        System.out.println("Employee Updated Successfully!");
    }

}
