<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Dish</title>
<link rel="stylesheet" type="text/css" href="css/msgBox.css">
</head>
<body>
<h1>New Dish Information</h1>
<form action="addDish" method="post" enctype="multipart/form-data">
	<input type="hidden" name="mid" value="${mid}"/><br/>
	Dish Name: <br/>
	<input type="text" name="dname" maxlength="30" required/><br/>
	Upload Dish Image: <br/>
	<input type="file" name="dishImage1" pattern=".+(.jpg|.png|.gif|.jepg)" required/><br/>
	<input type="file" name="dishImage2" pattern=".+(.jpg|.png|.gif|.jepg)" /><br/>
	
	<input type="submit" value="Add Dish"/>
</form>
<div id="${msgType}" class="centre">
${msg}
</div>
</body>
</html>