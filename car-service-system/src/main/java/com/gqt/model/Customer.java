
package com.gqt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Customer {
	private String name;
	private String username;
	private String password;
	private String result;
//	Connection con = null;

	public Customer(String name, String username, String password, String result) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.result = result;
	}

	public Customer() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	// non-static
//	{
//		try {
//			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gqt_november", "root", "root");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	// register
	public int CustomerRegister() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gqt_november", "root", "root");
			String s = "insert into customer values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, name);
			pstmt.setString(2, username);
			pstmt.setString(3, password);
			pstmt.setString(4, result);
			int rows = pstmt.executeUpdate();
			return rows;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	// login

	public int Customerlogin() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gqt_november", "root", "root");
			String s = "select * from customer where username=?";

			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, username);
			ResultSet res = pstmt.executeQuery();
			if (res.next()) {
				if (res.getString("password").equals(password)) {
					return 1; // valid credentials
				} else {
					return -1; // invalid password
				}
			} else {
				return 0; // invalid username
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
