<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Dish Information</title>
</head>
<body>
<h1>Update Dish Information</h1>
<form action="updateDish" method="post">
	<input type="hidden" name="mid" value="${d.merchantUuid}"/><br/>
	<input type="hidden" name="did" value="${d.dishId}"/><br/>
	Dish Name: <br/>
	<input type="text" name="dname" maxlength="30" value="${d.dishName}"/><br/>
	Dish Photo: <br/>
	
	<input type="submit" value="Update Dish"/>
</form>
</body>
</html>