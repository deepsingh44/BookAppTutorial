package com.deepsingh44.service;

import com.deepsingh44.dao.BookDao;
import com.deepsingh44.model.Book;

public class BookService {
	// singleton design pattern
	private static BookService bookService = new BookService();

	private BookService() {
	}

	public static BookService getBookService() {
		return bookService;
	}

	public String insert(Book book) {
		String msg = "";
		try {
			msg = (BookDao.getBookDao().addBook(book) > 0) ? "Successfully Added" : "Book Added Failed";
		} catch (Exception e) {
			msg = e.toString();
		}
		return msg;
	}
}
