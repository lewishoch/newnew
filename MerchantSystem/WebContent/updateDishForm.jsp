<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Dish Information</title>
<link rel="stylesheet" type="text/css" href="css/tab.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<style>
#bg {
	background: #1bc1b3;
}
h5 {
	color: #000;
	display: inline;
}
form {
	margin: 0 10%;
}
span {
	margin: 2px 10px;
	font-size: 15px;
	font-weight: bold;
}
</style>
</head>
<body id="bg">
<div class="tabs">
    <!-- Radio button and lable for #tab-content1 -->
    <input type="radio" class="radioTab" name="tabs" id="tab1" checked >
    <label for="tab1">
        <i class="fa fa-html5"></i><span>Update Dish Information</span>
    </label>
    <div id="tab-content1" class="tab-content">
<form action="updateDish" method="post" enctype="multipart/form-data">
	<input type="hidden" name="mid" value="${d.merchantUuid}"/>
	<input type="hidden" name="did" value="${d.dishId}"/>
	<input type="hidden" name="oldDName" value="${d.dishName}"/>
	<span>Dish Name</span>
	<input type="text" name="dname" maxlength="30" value="${d.dishName}" class="form-control" required/><br/>
	<span>Dish Photo</span></br>
	<span>Upload Dish Image</span>
	<input type="file" name="dishImage1" pattern=".+(.jpg|.png|.gif|.jepg)" required/><br/>
	<input type="file" name="dishImage2" pattern=".+(.jpg|.png|.gif|.jepg)" /><br/>
	
	
	
	<input type="submit" value="Update Dish"/></br></br>
</form>
</div>
</div>
<div id="${msgType}" class="centre">
${msg}
</div>
</body>
</html>