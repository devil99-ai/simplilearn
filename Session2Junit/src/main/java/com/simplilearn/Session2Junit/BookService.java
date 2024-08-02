package com.simplilearn.Session2Junit;

import java.util.ArrayList;
import java.util.List;

public class BookService {
	
	List<Book> books = new ArrayList<Book>();
	
	public void addBook(Book book) {
		books.add(book);
		System.out.println("Book "+book.getTitle()+" added..."
				);
	}
	public List<Book> getBooks(){
		return books;
	}
	
	public Book getBookById(int id) {
		//Book foundBook=null;
		for (Book book : books) {
			if(book.getBookId()==id) {
				//foundBook=book;
				//break;
				return book;
			}
		}
		return null;
	}

}
