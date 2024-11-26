package com.gqt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gqt.model.Customer;


public class CustomerRegister extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		String result =request.getParameter("result");
		
		Customer c=new Customer(name,username,password,result);
		int status=c.CustomerRegister();
		if(status==1) {
			response.sendRedirect("/car-service-system/customer-register-success.jsp");
		}
		else	 {
			response.sendRedirect("/car-service-system/customer-register-failure.jsp");
		}
		
		
	}
}
