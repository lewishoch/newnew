<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administration System</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>
<h1>Hello ${name}</h1>
<br />
<div class="list-group" style="width:400px">
<a class="list-group-item" href="listPendingMerchant">
	Accept / Reject Merchant Request 
	<span class="badge">${size}</span>
</a>
<a class="list-group-item" href="listAllMerchants">Freeze / Unfreeze Merchant Account</a>
</div>

<form action="logout" method="post">
    <input class="btn btn-primary" type="submit" value="Logout" />
</form>
</body>
</html>