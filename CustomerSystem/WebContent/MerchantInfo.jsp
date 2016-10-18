<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Merchant Info</title>
<link rel="stylesheet" type="text/css" href="css/msgBox.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="css/tab.css">
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
        <i class="fa fa-html5"></i><span>Merchant Information</span>
    </label>
    <!-- Radio button and lable for #tab-content2 -->
    <input type="radio" class="radioTab" name="tabs" id="tab2">
    <label for="tab2">
        <i class="fa fa-css3"></i><span>Dish Information</span>
    </label>
    
    <div id="tab-content1" class="tab-content">
	<h3>Merchant Information</h3>
	<table class="table table-striped">
	<tr>
		<th>Merchant ID</th>
		<th>Merchant Name</th>
		<th>Merchant Age</th>
		<th>Merchant Gender</th>
		<th>Shop Logo</th>
		<th>Shop Name</th>
		<th>Shop Address</th>
		<th>Shop Tel Number</th>
	</tr>
	<tr>
	<td>${merchant.uuid }</td>
	<td>${merchant.mName }</td>
	<td>${merchant.mAge }</td>
	<td>${merchant.mGender }</td>
	<td><img src="http://localhost:8081${merchant.sLogoPath }" width="100" /></td>
	<td>${merchant.sName }</td>
	<td>${merchant.sAddr }</td>
	<td>${merchant.sTel }</td>
	</tr>
	</table>
	</div>
    
    <div id="tab-content2" class="tab-content">
	<h3>Dish Information</h3>
		<table class="table table-striped">
			<tr><th>Dish Name</th><th>Dish Photo</th></tr>
			<c:forEach var="d" items="${dishes}">
				<tr>
					<td>
						${d.dishName}
					</td>
					<td>
						<c:forEach var="p" items="${d.dishPath}">
							<img src="${p }" alt="" height="100"/>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>