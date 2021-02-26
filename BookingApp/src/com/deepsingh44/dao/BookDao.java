package com.deepsingh44.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.deepsingh44.model.Book;

public class BookDao {
	// singleton design pattern
	private static BookDao bookDao = new BookDao();

	private BookDao() {
	}

	public static BookDao getBookDao() {
		return bookDao;
	}

	public int addBook(Book book) throws SQLException {
		PreparedStatement ps = Dao.getConnection().prepareStatement("insert into books values(default,?,?,?,?)");
		ps.setString(1, book.getTitle());
		ps.setString(2, book.getAuthor());
		ps.setFloat(3, book.getPrice());
		ps.setString(4, book.getImage());
		return ps.executeUpdate();
	}
}
