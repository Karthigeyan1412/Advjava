package com.test.Employeehibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private int id;

	 @Column(name = "name")
	    private String name;
	 
	 @Column(name = "email")
	    private String email;
	 @Column(name = "salary")
	    private int salary;
	 
	 @Override
	 public String toString() {
	     return "Employee {" +
	             "id=" + id +
	             ", name='" + name + '\'' +
	             ", email='" + email + '\'' +
	             ", salary=" + salary +
	             '}';
	 }

	public Employee() {
		super();
	}
	public Employee(String name, String email, int salary) {
		super();
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
	public Employee(int id, String name, String email, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	 
}
