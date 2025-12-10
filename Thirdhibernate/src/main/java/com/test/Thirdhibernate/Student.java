package com.test.Thirdhibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private Integer mark;

    @Column(name = "email")
    private String email;

	public Student() {
		super();
	}
	

	public Student(int id, String name, Integer mark, String email) {
		super();
		this.id = id;
		this.name = name;
		this.mark = mark;
		this.email = email;
	}


	public Student(String name, Integer mark, String email) {
		super();
		this.name = name;
		this.mark = mark;
		this.email = email;
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

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
}

