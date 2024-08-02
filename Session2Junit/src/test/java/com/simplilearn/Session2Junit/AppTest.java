package com.simplilearn.Session2Junit;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {
	@Test
	public void assertTrueWithNoMessage() {
		BookService service = new BookService();
		List<Book> books=service.getBooks();
		
		assertTrue(books.isEmpty());
	}
	@Test
	public void assertNullWithNoMessage() {
		BookService service = new BookService();
		Book book1 = new Book(101,"Head first java","Wrox");
		Book book2 = new Book(102,"Head first python","Pyjan");
		
		service.addBook(book1);
		service.addBook(book2);
		Book actualBook = service.getBookById(103);
		assertNull(actualBook,"Book Not Found");
	}
	@Test
	public void assertNotNullWithNoMessage() {
		BookService service = new BookService();
		Book book1 = new Book(101,"Head first java","Wrox");
		Book book2 = new Book(102,"Head first python","Pyjan");
		
		service.addBook(book1);
		service.addBook(book2);
		Book actualBook = service.getBookById(102);
		assertNotNull(actualBook,"Book Found");
	}
	@Test
	public void assertEqualWithNoMessage() {
		BookService service = new BookService();
		Book book1 = new Book(101,"Head first java","Wrox");
		Book book2 = new Book(102,"Head first python","Pyjan");
		
		service.addBook(book1);
		service.addBook(book2);
		Book actualBook = service.getBookById(102);
		assertEquals(102,actualBook.getBookId(), "book 102 not found");
		assertEquals("Head first python",actualBook.getTitle(),"book head first java not found");
	}
}