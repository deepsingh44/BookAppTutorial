package com.deepsingh44.service;

import java.util.ArrayList;
import java.util.List;

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

	public List<Book> getAllBooks() {

		try {
			return BookDao.getBookDao().getAllBooks();
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ArrayList<>();
	}
	
	public String deleteBookById(int id) {
		String msg = "";
		try {
			msg = (BookDao.getBookDao().deleteBook(id) > 0) ? "Successfully Deleted" : "Book Deleted Failed";
		} catch (Exception e) {
			msg = e.toString();
		}
		return msg;
	}
}
