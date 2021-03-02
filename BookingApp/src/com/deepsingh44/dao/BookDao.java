package com.deepsingh44.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public int deleteBook(int id) throws SQLException {
		PreparedStatement ps = Dao.getConnection().prepareStatement("delete from books where bookid=?");
		ps.setInt(1, id);
		return ps.executeUpdate();
	}

	public List<Book> getAllBooks() throws SQLException {
		List<Book> books = new ArrayList<>();
		PreparedStatement ps = Dao.getConnection().prepareStatement("select * from books");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Book book = new Book(rs.getString(2), rs.getString(3), rs.getString(5), rs.getFloat(4));
			book.setId(rs.getInt(1));
			books.add(book);
		}
		return books;
	}
}
