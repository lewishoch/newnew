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
<h1>Accepted Merchants</h1>
<a href="index.html">back to home</a>
<br /><br />
<table class="table table-striped">
	<tr><th>Merchant ID</th><th>Merchant Name</th><th>Merchant Status</th><th>Freeze Operation</th><th>Unfreeze Operation</th></tr>
	<c:forEach var="m" items="${maList}">
		<tr>
			<td>${m.uuid }</td>
			<td><a href="showMerchant?uuid=${m.uuid}" >${m.uname }</a></td>			
			<td>${m.status}</td>
			<td><a href="freezeMerchant?uuid=${m.uuid }" class="btn btn-primary ${m.status==0? '':'disabled' }">Freeze</a></td>
			<td><a href="unfreezeMerchant?uuid=${m.uuid }" class="btn btn-default ${m.status==3? '':'disabled' }">Unfreeze</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>