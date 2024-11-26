package com.gqt.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gqt.model.Customer;


public class CustomerLogin extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		
		Customer c=new Customer();
		c.setUsername(username);
		c.setPassword(password);
		int status = c.Customerlogin();
		if(status == 1) {
			response.sendRedirect("/car-service-system/customer-login-success.jsp");
		}
		else if(status == 0){
			response.sendRedirect("/car-service-system/invalid-customer-username.jsp");
		}
		else {
			response.sendRedirect("/car-service-system/invalid-customer-password.jsp");
		}
	}
}




