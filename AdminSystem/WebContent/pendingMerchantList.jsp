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

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>All Pending Registration Requests</h1>
<table class="table table-striped">
	<tr><th>Merchant ID</th><th>Merchant Name</th><th>Merchant Status</th><th>Accept Operation</th><th>Reject Operation</th></tr>
	<c:forEach var="m" items="${maList}">
		<tr>
			<td>${m.uuid }</td>
			<td><a href="showMerchant?uuid=${m.uuid}" >${m.uname }</a></td>
			<td>${m.status }</td>
			<td><a href="acceptMerchant?uuid=${m.uuid }" class="btn btn-primary">Accept</a></td>
			<td><a href="#" class="btn btn-success">Reject</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>