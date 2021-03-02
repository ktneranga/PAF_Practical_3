<%@page import="CRUD.InsertValues"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

String user_name=request.getParameter("user_name");
String email=request.getParameter("email");
String mobile=request.getParameter("mobile");

//create an object of InsertValues
InsertValues obj_insert = new InsertValues();

//insert values through the object
obj_insert.insertValues(user_name, email, mobile);

%>

<!-- redirect to the main insert value page -->
<script type="text/javascript">window.location.href="http://localhost:9090/UserList/insert_value.jsp"</script>

</body>
</html>