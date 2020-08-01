<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 if (session.getAttribute("error")!=null)
 {
	 String error=(String)session.getAttribute("error");
	 out.println(error);
	 session.removeAttribute("error");
 }
%>
<form action="change_password" method="post">
Please re-enter the old password:<br>
<input type="text" name="oldpw"><br>
Please enter the new password:<br>
<input type="text" name="newpw"><br>
<input type="submit" value="submit">
</form>
</body>
</html>