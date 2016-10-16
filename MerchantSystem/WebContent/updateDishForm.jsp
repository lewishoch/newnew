<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Dish Information</title>
</head>
<body>
<h1>Update Dish Information</h1>
<form action="updateDish" method="post" enctype="multipart/form-data">
	<input type="hidden" name="mid" value="${d.merchantUuid}"/><br/>
	<input type="hidden" name="did" value="${d.dishId}"/><br/>
	<input type="hidden" name="oldDName" value="${d.dishName}"/><br/>
	Dish Name: <br/>
	<input type="text" name="dname" maxlength="30" value="${d.dishName}" required/><br/>
	Dish Photo: <br/>
	Upload Dish Image: <br/>
	<input type="file" name="dishImage1" pattern=".+(.jpg|.png|.gif|.jepg)" required/><br/>
	<input type="file" name="dishImage2" pattern=".+(.jpg|.png|.gif|.jepg)" /><br/>
	
	
	
	<input type="submit" value="Update Dish"/>
</form>
<div id="${msgType}" class="centre">
${msg}
</div>
</body>
</html>