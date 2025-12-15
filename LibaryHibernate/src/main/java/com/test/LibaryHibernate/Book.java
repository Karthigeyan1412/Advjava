package com.test.LibaryHibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column
	 private int id;
	 
	 @Column
	 private String name;
	 
	 @Column
	 private int price;
	 
	 @Column
	 private int noOfpages;
	 
	 @ManyToOne(cascade = CascadeType.PERSIST)
	 @JoinColumn(name = "author_id")   // foreign key column in book table
	    private Author author;

	 
	 
	public Book() {
		super();
	}


	public Book( String name, int price, int noOfpages) {
		super();
		this.name = name;
		this.price = price;
		this.noOfpages = noOfpages;
	}


	public Book(int id, String name, int price, int noOfpages, int author_id) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.noOfpages = noOfpages;
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


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getNoOfpages() {
		return noOfpages;
	}


	public void setNoOfpages(int noOfpages) {
		this.noOfpages = noOfpages;
	}


	 public Author getAuthor() {
	        return author;
	    }

	    public void setAuthor(Author author) {
	        this.author = author;
	    }
	
	 
	
}
