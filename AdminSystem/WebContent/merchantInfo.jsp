<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Merchant Information</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Merchant Information</h1>
<ul class="list-group">
	<li class="list-group-item">merchant name: ${mp.mName }</li>
	<li class="list-group-item">merchant age: ${mp.mAge }</li>
	<li class="list-group-item">merchant gender: ${mp.mGender }</li>
	<li class="list-group-item">shop name: ${mp.sName }</li>
	<li class="list-group-item">shop address: ${mp.sAddr }</li>
	<li class="list-group-item">shop phone number: ${mp.sTel }</li>
	<li class="list-group-item">created date: ${mp.creDt }</li>
</ul>
</body>
</html>