package com.OnlineBookStore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Book
{
	public Book() {
		super();
	}
	public Book(int id, String name, String author, String price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String author;
	private String price;
}
