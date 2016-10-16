<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Merchant System</title>
<link rel="stylesheet" type="text/css" href="css/msgBox.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="account.jsp" />
<div id="content">
	<div id="shop">

		<h1>Your Profile</h1>
		<table class="table table-striped">
			<tr><th>Merchant Name</th><th>Merchant Gender</th><th>Merchant Age</th><th>Shop Name</th><th>Shop Address</th><th>Shop Tel Number</th><th>Shop Logo</th><th>Edit</th></tr>
			<tr>
				<td>${merchantProfile.mName}</td>
				<td>${merchantProfile.mGender}</td>
				<td>${merchantProfile.mAge}</td>
				<td>${merchantProfile.sName}</td>
				<td>${merchantProfile.sAddr}</td>
				<td>${merchantProfile.sTel}</td>
				<td><img src="${merchantProfile.sLogoPath}" alt="shopLogo"  height="100"  ></td>
				<td><a class =  "btn btn-success" href = "editProfile?muuid=${merchantProfile.uuid}">Edit</a></td>
			</tr>
		
		</table>

	</div>
	
	<div id="dish">
		<h1>Your Dishes</h1>
		<table class="table table-striped">
			<tr><th>Dish Name</th><th>Dish Photo</th><th>Delete</th><th>Edit</th></tr>
			<c:forEach var="d" items="${dishes}">
				<tr>
					<td>
						<a href="showDish?id=${d.dishId}">${d.dishName}</a>
					</td>
					<td>
					<c:forEach var="p" items="${d.dishPath}">
						<img src=${p} alt="" height="100"/>
					</c:forEach>
					</td>
					<td><a class="btn btn-primary" href="deleteDish?dishId=${d.dishId}">Delete</a></td>
					<td><a class="btn btn-success" href="editDish?dishId=${d.dishId}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
		<a class="btn btn-success" href="insertDish?mid=${merchantProfile.uuid}">Add New Dish</a>
	</div>
</div>
<div id="${msgType }" class="centre">
${msg }
</div>
</body>
</html>