package com.OnlineBookStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="MyBooks")
public class MyBooksList 
{
	@Id
	@Column(name="book_id")
	private int id;
	private String name;
	private String author;
	private String price;
	public MyBooksList(int id, String name, String author, String price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}
	public MyBooksList() {
		super();
	}
	
}
