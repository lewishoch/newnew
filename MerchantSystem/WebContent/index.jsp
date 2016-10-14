<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Merchant System</title>
</head>
<body>
<div id="login">
<form action="login" method="post">
	<label>User Name: </label><input type="text" name="uname"/></br>
	<label>Password: </label><input type="password" name="password"/></br>
	<input type="submit" value="Sign In"/>
	<input type="reset"/>
</form>
</div>
	<div id="signup">
	<form action="signUp" method="post">
	<div id="account_info">
		<label>Account</label></br>
		<label>User Name: </label><input type="text" name="uname"/></br>
		<label>Password: </label><input type="password" name="password"/></br>
	</div>
	<div id="merchant_shop_info">
	<div id="merchant_info">
		<label>Merchant</label></br>
		<label>Name: </label><input type="text" name="mname"/></br>
		<label>Age: </label><input type="number" name="age" pattern="[0-9]+"/></br>
		<label>Gender: </label><input type="radio" value="M" checked="checked" name="gender"/><label>Male </label><input type="radio" value="F" name="gender"/><label>Female </label></br>
	</div>
	<div id="shop_info">
		<label>Shop</label></br>
		<label>Shop Name: </label><input type="text" name="shopName"/></br>
		<label>Shop Address: </label><input type="text" name="address"/></br>
		<label>Tel. No: </label><input type="text" name="telno" pattern="[0-9]+"/></br>
		<label>Upload Shop Logo: </label><input type="file" name="slogo" pattern=".+(.jpg|.png|.gif|.jepg)"/></br>
	</div>
	</div>
	<div id="signup_submit">
		<input type="submit" value="Sign Up"/>
		<input type="reset"/>
	</div>
</form>
</div>
</body>
</html>