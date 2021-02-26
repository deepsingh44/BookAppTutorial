package com.deepsingh44.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.deepsingh44.model.User;

public class UserDao {
	// singleton design pattern
	private static UserDao userDao = new UserDao();

	private UserDao() {
	}

	public static UserDao getUserDao() {
		return userDao;
	}

	public int register(User user) throws SQLException {
		PreparedStatement ps = Dao.getConnection().prepareStatement("insert into users values(?,?,?,?,?)");
		ps.setString(1, user.getFirstname());
		ps.setString(2, user.getLastname());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getPassword());
		ps.setString(5, user.getImage());
		return ps.executeUpdate();
	}

	public User login(String email,String pass) throws SQLException {
		User user=null;
		PreparedStatement ps = Dao.getConnection().prepareStatement("select * from users where email=? and pass=?");
		ps.setString(1, email);
		ps.setString(2, pass);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			user=new User(rs.getString(1), rs.getString(2), email, pass, rs.getString(5));
		}
		return user;
	}
	
}
