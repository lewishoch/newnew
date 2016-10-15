<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Merchant Info</h1>
<ul>
	<li>Merchant ID: ${merchant.uuid }
	<li>Merchant Name: ${merchant.mName }</li>
	<li>Merchant Age: ${merchant.mAge }</li>
	<li>Merchant Gender: ${merchant.mGender }</li>
	<li>Shop Name: ${merchant.sName }</li>
	<li>Shop Address: ${merchant.sAddr }</li>
	<li>Shop Tel Number: ${merchant.sTel }</li>

	
</ul>
</body>
</html>