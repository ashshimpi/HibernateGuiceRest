package com.axelor.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

public class Success extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 PrintWriter writer = resp.getWriter();
		 
	        
	        String name= (String) req.getSession(false).getAttribute("name");
	        String salary= (String) req.getSession(false).getAttribute("salary");
	        String dept= (String) req.getSession(false).getAttribute("dept");
	        writer.println("Details Added Successfully");
	        writer.println(""+name);
	        writer.println(""+salary);
	        writer.println(""+dept);
	}
	
}
