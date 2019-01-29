<%@page import="com.axelor.pojo.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,org.hibernate.*,org.hibernate.cfg.*" %>
<%! String dept;String sal; String name; Session session1 = null; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="viewdata">
		
		<table width="220" border="1">
		<tr><th>NUMBER</th><th>NAME</th><th>SALARY</th></tr>                     
		<%
		Configuration cf=new Configuration();
		cf.configure();
		SessionFactory sf = cf.buildSessionFactory();
		session1 =sf.openSession();
		//Using from Clause
		String SQL_QUERY ="from Employee";
		Query query = session1.createQuery(SQL_QUERY);
		Iterator it=query.iterate();
		while(it.hasNext())
		{
		Employee e=(Employee)it.next();
		name=e.getEname();
		sal=e.getSalary();
		dept=e.getDept();            
		%>                  
		<tr>
		<td><%=name%></td>
		<td><%=sal%></td>
		<td><%=dept%></td>
		</tr>
		<%
		}
		session1.close();
		%>
		</table>
</form>
</body>
</html>