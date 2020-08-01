<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body{
background-image: url(CSS/index.jpg);
color: white;
}
.topnav {
  overflow: hidden;
  
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}
button {
	  border: none;
	  color: black;
	  padding: 15px 32px;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	  font-size: 16px;
	  margin: 4px 2px;
	  cursor: pointer;
	  background-color:white;
	  width: 250px;
	  
	  
	}

</style>
</head>
<body>
<% if (session.getAttribute("uname")==null||session.getAttribute("upassword")==null)
{	response.sendRedirect("login.html");
	}
%>
<div class="topnav">
  <a class="active" href="salesmanChoice.jsp">Salesman_Home</a>
  <a href="ExitPage.jsp">Sign_Out</a>
</div>
<center><h1>Welcome to the salesman page!</h1></center>
<center><p>Hello ${uname}, Please choose the operation you want:</p></center>
<center><a href="addGood.html"><button>add a new good to the depot</button></a></center>
<center><a href="updateGood.html"><button>update a good information</button></a></center>
<center><a href="deleteGood.html"><button>delete a good</button></a></center>
<center><a href="changePassword.jsp"><button>change your password</button></a></center>

</body>
</html>