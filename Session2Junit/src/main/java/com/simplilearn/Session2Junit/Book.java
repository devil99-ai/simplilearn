package com.simplilearn.Session2Junit;

public class Book {
	private int bookId;
	private String title;
	private String publisher;
	
	public Book(){
		
	}
	public Book(int bookId, String title, String publisher) {
		this.bookId = bookId;
		this.title = title;
		this.publisher = publisher;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", publisher=" + publisher + "]";
	}

}
