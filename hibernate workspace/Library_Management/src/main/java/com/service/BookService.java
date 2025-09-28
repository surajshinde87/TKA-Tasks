package com.service;

import com.dao.BookDAO;
import com.entity.Book;

public class BookService {
	BookDAO bd = new BookDAO();

	public void addBook(String title, String author) {
		Book b = new Book();
		b.setTitle(title);
		b.setAuthor(author);
		b.setAvailable(true);
		bd.addBook(b);
	}

	public void updateBook(int bookId, String title, String author, boolean available) {
		Book b = bd.getBookById(bookId);
		if (b != null) {
			b.setTitle(title);
			b.setAuthor(author);
			b.setAvailable(available);
			bd.updateBook(b);
		}
	}

	public void getBookById(int bookId) {
		Book book = bd.getBookById(bookId);
		if (book != null) {
			System.out.println(book);
		
		} else {
			System.out.println("Book not found with ID: " + bookId);
		}
	}
}
