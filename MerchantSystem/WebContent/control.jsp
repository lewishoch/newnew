<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Merchant System</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<div id="account_control">
	<form action="logout" method="post">
		<label>Welcome, ${account.name}!</label>
		<input type="submit" value="Logout"/>
	</form>
	</div>
<div id="content">
	<div id="shop">
		<h1>Your Profile</h1>
<table class="table table-striped">
	<tr><th>Merchant Name</th><th>Merchant Age</th><th>Shop Name</th><th>Shop Address</th><th>Shop Tel Number</th><th>Edit</th></tr>
	<tr>
		<td>${merchantProfile.mName}</td>
		<td>${merchantProfile.mAge}</td>
		<td>${merchantProfile.sName}</td>
		<td>${merchantProfile.sAddr}</td>
		<td>${merchantProfile.sTel}</td>
		<td><a class =  "btn btn-success" href = "editUser?id=${u.id}">Edit</a></td>
	</tr>

</table>
	</div>
	<div id="dish">
		
	</div>
</div>
</body>
</html>