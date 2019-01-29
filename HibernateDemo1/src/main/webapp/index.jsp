<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
<form action="register" method="post">
        <table cellpadding="3pt">
            <tr>
                <td>User Name :</td>
                <td><input type="text" name="ename" size="30" /></td>
            </tr>
            
            <tr>
                <td>salary :</td>
                <td><input type="text" name="salary" size="30" /></td>
            </tr>
            <tr>
                <td>department :</td>
                <td><input type="text" name="dept" size="30" /></td>
            </tr>
            
        </table>
        <p />
        <input type="submit" value="Register" />
        <a href="view.jsp">ViewData</a><br><br>
        <a href="update.jsp">Update</a><br><br>
        <a href="delete.jsp">Delete</a><br><br>
    </form>
</body>
</html>