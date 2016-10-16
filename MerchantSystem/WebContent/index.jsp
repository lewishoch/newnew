<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Merchant System</title>
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
<div class="tabs">
    <!-- Radio button and lable for #tab-content1 -->
    <input type="radio" class="radioTab" name="tabs" id="tab1" checked >
    <label for="tab1">
        <i class="fa fa-html5"></i><span>Login</span>
    </label>
    <!-- Radio button and lable for #tab-content2 -->
    <input type="radio" class="radioTab" name="tabs" id="tab2">
    <label for="tab2">
        <i class="fa fa-css3"></i><span>Sign Up</span>
    </label>
    
    <div id="tab-content1" class="tab-content">
        <form action="login" method="post" class="form-group">
        	<fieldset>
        	<legend>Login</legend>
			<span>User Name </span><input type="text" name="uname" class="form-control" placeholder="User Name" required/></br>
			<span>Password </span><input type="password" name="password" class="form-control" placeholder="Password" required/></br>
			</br></br>
			<input type="submit" value="Sign In" class="btn btn-primary"/>
			<input type="reset" class="btn btn-default" value="Reset" class="btn btn-warning"/>
			</fieldset>
		</form>
    </div> <!-- #tab-content1 -->
    <div id="tab-content2" class="tab-content">
        <form action="signUp" method="post" enctype="multipart/form-data" class="form-group">
        <fieldset>
       		<legend>Sign Up</legend>
			<div id="account_info" class="form-group">
				<span>User Name </span><input type="text" name="uname" class="form-control" placeholder="User Name" required/></br>
				<span>Password </span><input type="password" name="password" class="form-control" placeholder="Password" required/></br>
			</div>
			<div id="merchant_shop_info" class="form-group">
			<div id="merchant_info" class="form-group">
				<span>Merchant Name </span><input type="text" name="mname" class="form-control" placeholder="Merchant Name" required/></br>
				<span>Merchant Age </span><input type="number" name="age" pattern="[0-9]+" class="form-control" placeholder="Merchant Age" required/></br>
				<span>Merchant Gender      </span></br>
				<input type="radio" value="M" checked="checked" name="gender"/><h5>Male </h5><input type="radio" value="F" name="gender"/><h5> Female </h5></br>
			</div></br>
			<div id="shop_info" class="form-group">
				<span>Shop Name </span><input type="text" name="shopName" class="form-control" placeholder="Shop Name" required/></br>
				<span>Shop Address </span><input type="text" name="address" class="form-control" placeholder="Shop Address" required/></br>
				<span>Tel. No </span><input type="text" name="telno" pattern="[0-9]+" class="form-control" placeholder="Tel. no" required/></br>
				<span>Upload Shop Logo </span><input type="file" color="#000" name="slogo" pattern=".+(.jpg|.png|.gif|.jepg)" placeholder="Upload Shop Logo" required/></br>
			</div>
			</div>
			</br></br>
			<div id="signup_submit">
				<input type="submit" value="Sign Up" class="btn btn-success"/>
				<input type="reset" class="btn btn-default" value="Reset" class="btn btn-warning"/>
			</div>
			</fieldset>
		</form>
    </div> <!-- #tab-content2 -->
</div>
<div id="${msgType }" class="centre">
${msg }
</div>
</body>
</html>