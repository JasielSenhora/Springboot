package com.example.day5.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Bookmodel")
public class BookModel {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="bookid")
   private int bookId;
   @Column(name="bookname")
   private String bookName;
   @Column(name="authorname")
   private String authorName;
   @Column(name="co-authorname")
   private String coAuthorName;
   @Column(name="yearofpublishing")
   private int yearOfPublishing;
   public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String boookName) {
	this.bookName = boookName;
}
public String getAuthorName() {
	return authorName;
}
public void setAuthorName(String authorName) {
	this.authorName = authorName;
}
public String getCoAuthorName() {
	return coAuthorName;
}
public void setCoAuthorName(String coAuthorName) {
	this.coAuthorName = coAuthorName;
}
public int getYearOfPublishing() {
	return yearOfPublishing;
}
public void setYearOfPublishing(int yearOfPublishing) {
	this.yearOfPublishing = yearOfPublishing;
}
   
}
