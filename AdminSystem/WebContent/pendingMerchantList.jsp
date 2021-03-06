<%@page import="protocol.AccountStatusProtocol"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administration System</title>
<link rel="stylesheet" type="text/css" href="css/msgBox.css">
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
<jsp:include page="session.jsp" />
<jsp:include page="account.jsp" />
<div class="tabs">
    <!-- Radio button and lable for #tab-content1 -->
    <input type="radio" class="radioTab" name="tabs" id="tab1" checked >
    <label for="tab1">
        <i class="fa fa-html5"></i><span>Pending Requests</span>
    </label>
    
    <div id="tab-content1" class="tab-content">
<h3>Pending Requests</h3>
<a href="showHome">back to home</a>
<br /><br />
<table class="table table-striped">
	<tr><th>Merchant ID</th><th>Merchant Name</th><th>Merchant Status</th><th>Accept Operation</th><th>Reject Operation</th></tr>
	<c:forEach var="m" items="${maList}">
		<tr>
			<td>${m.uuid }</td>
			<td><a href="showMerchant?uuid=${m.uuid}&parent=listPendingMerchant" >${m.uname }</a></td>			
			<td>Pending</td>
			<td><a href="acceptMerchant?uuid=${m.uuid }" class="btn btn-success">Accept</a></td>
			<td><a href="rejectMerchant?uuid=${m.uuid }" class="btn btn-danger">Reject</a></td>
		</tr>
	</c:forEach>
</table>
</div></div>
</body>
</html>