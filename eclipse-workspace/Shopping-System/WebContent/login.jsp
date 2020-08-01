<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<title></title>
	<link rel="stylesheet" href="CSS/login.css">
</head>
<body>
<div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div><span>Welcome</span></div>
		</div>
		<br>
		<div class="login">
		<% 
		if (request.getAttribute("sign_in_error")!=null)
		{
			out.println(request.getAttribute("sign_in_error"));
			request.removeAttribute("sign_in_error");
		}
		%>
		<form action="sign_in" method="post">
				<input type="text" placeholder="username" name="username"><br>
				<input type="text" placeholder="password" name="password"><br>
				<input type="submit" value="Login">
		</form>
	</div>
</body>
</html>