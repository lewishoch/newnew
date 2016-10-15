<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Dish</title>
</head>
<body>
<h1>New Dish Information</h1>
<form action="addDish" method="post" enctype="multipart/form-data">
	<input type="hidden" name="mid" value="${mid}"/><br/>
	Dish Name: <br/>
	<input type="text" name="dname" maxlength="30"/ required><br/>
	Upload Dish Image: <br/>
	<input type="file" name="dishImage1" pattern=".+(.jpg|.png|.gif|.jepg)" required/><br/>
	<input type="file" name="dishImage2" pattern=".+(.jpg|.png|.gif|.jepg)" /><br/>
	
	<input type="submit" value="Add Dish"/>
</form>
</body>
</html>