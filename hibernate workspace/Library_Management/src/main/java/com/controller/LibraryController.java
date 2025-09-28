package com.controller;

import com.service.BookService;
import com.service.UserService;

public class LibraryController {

	public static void main(String[] args) {

		BookService bs = new BookService();
		UserService us = new UserService();

		// Books Controller
//		bs.addBook("Java Programming", "James Gosling");
//		bs.addBook("Rich Dad Poor Dad", "Robert Kiyosaki");
//		bs.addBook("Gitanjali", "Ravindranath Tagore");
//		bs.getBookById(1);
//		bs.updateBook(1, "Java Programming", "James Gosling", false);

		// User Controller
//		us.addUser("Suraj", "suraj@gmail.com");
//		us.addUser("Ram Patil", "rampatil@gmail.com");
//		us.addUser("Aniket", "aniket@gmail.com");
//		us.borrowBook(3, 3);    // userid bookid
//		us.getUserById(4);        
		us.returnBook(2);         // bookid

	}
}
