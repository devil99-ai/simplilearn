package com.simplilearn.Session2Junit;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
@Disabled("Untill the issue fixed")
public class AppTest1 {
	
	@Test
	public void testBooks() {
		
		BookService service = new BookService();
		service.addBook(new Book(101,"Head first java","Wrox"));
		service.addBook(new Book(102,"Head first python","Pyjan"));
		
		Book actualBook = service.getBookById(101);
		assertEquals(101,actualBook.getBookId());
		assertEquals("Head first java", actualBook.getTitle());
	}
	@Test
	public void testBookPublisher() {
		
		BookService service = new BookService();
		service.addBook(new Book(101,"Head first java","Wrox"));
		service.addBook(new Book(102,"Head first python","Pyjan"));
		
		Book actualBook = service.getBookById(101);
		//assertEquals(101,actualBook.getBookId());
		assertEquals("Wrox", actualBook.getPublisher());
	}

}
