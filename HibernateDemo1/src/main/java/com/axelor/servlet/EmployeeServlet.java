package com.axelor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.axelor.main.EmployeeDAO;

public class EmployeeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ename = req.getParameter("ename");
        String salary = req.getParameter("salary");
        String dept = req.getParameter("dept");
       
 
        HttpSession session = req.getSession(true);
        try {
            EmployeeDAO empDAO = new EmployeeDAO();
            empDAO.addUserDetails(ename, salary, dept);
            session.setAttribute("name", ename);
            session.setAttribute("salary", salary);
            session.setAttribute("dept", dept);
            resp.sendRedirect("Success");
            
        } catch (Exception e) {
 
            e.printStackTrace();
        }
	}
}
