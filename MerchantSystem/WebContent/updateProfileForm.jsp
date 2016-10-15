<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="updateProfile" method="post">
	<input type="hidden" name="uuid" value="${merchantProfile.uuid}"/>
	<input type="hidden" name="mAccountUuid" value="${merchantProfile.mAccountUuid}"/>
	Merchant Name: <input type="text" name="mName" value="${merchantProfile.mName}" readonly><br/>
	Merchant Gender: <input type="text" name="mGender" maxlength="30" value="${merchantProfile.mGender}" readonly/><br/>
	Merchant Age: <input type="text" name="mAge" value="${merchantProfile.mAge}" readonly><br/>
	Shop Name: <input type="text" name="sName" maxlength="30" value="${merchantProfile.sName}"readonly/><br/>
	Shop Address: <input type="text" name="sAddr" maxlength="30" value="${merchantProfile.sAddr}"/><br/>
	Shop Tel Number: <input type="text" name="sTel" maxlength="30" value="${merchantProfile.sTel}"/><br/>
	<input type="submit"/>
</form>
</body>
</html>