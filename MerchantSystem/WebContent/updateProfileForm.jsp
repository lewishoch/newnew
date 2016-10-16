<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<jsp:include page="account.jsp" />
<div class="tabs">
    <!-- Radio button and lable for #tab-content1 -->
    <input type="radio" class="radioTab" name="tabs" id="tab1" checked >
    <label for="tab1">
        <i class="fa fa-html5"></i><span>Login</span>
    </label>
    <div id="tab-content1" class="tab-content">
<form action="updateProfile" method="post" enctype="multipart/form-data">
	<input type="hidden" name="uuid" value="${merchantProfile.uuid}" class="form-control"/>
	<input type="hidden" name="mAccountUuid" value="${merchantProfile.mAccountUuid}" class="form-control"/>
	<input type="hidden" name="shopLogoPath" value="${merchantProfile.sLogoPath}" class="form-control"/>
	<span>Merchant Name</span> <input type="text" name="mName" value="${merchantProfile.mName}" class="form-control" readonly>
	<span>Merchant Gender</span> <input type="text" name="mGender" maxlength="30" value="${merchantProfile.mGender}" class="form-control" readonly/><br/>
	<span>Merchant Age</span> <input type="text" name="mAge" value="${merchantProfile.mAge}"class="form-control"  readonly><br/>
	<span>Shop Name</span> <input type="text" name="sName" maxlength="30" value="${merchantProfile.sName}" class="form-control" readonly/><br/>
	<span>Shop Address</span> <input type="text" name="sAddr" maxlength="30" value="${merchantProfile.sAddr}" class="form-control" required/><br/>
	<span>Shop Tel Number</span> <input type="text" name="sTel" maxlength="30" value="${merchantProfile.sTel}" pattern="[0-9]+" class="form-control" required/><br/>
	<span>Shop Logo</span> <img src="${merchantProfile.sLogoPath}" alt="shopLogo"  height="100"><br/>
	<span>Update Shop Logo</span> <input type="file" name="slogo" pattern=".+(.jpg|.png|.gif|.jepg)"/><br/><br/>
	<input type="submit"/>
</form>
</div>
</div>
</body>
</html>