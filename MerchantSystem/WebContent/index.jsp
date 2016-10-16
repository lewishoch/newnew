<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Merchant System</title>
<link rel="stylesheet" type="text/css" href="css/msgBox.css">
<link rel="stylesheet" type="text/css" href="css/tab.css">
<style type="text/css">
table {
	padding: 5px, auto;
	margin: 5px, auto;
}
</style>

</head>
<body>
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
        <form action="login" method="post">
			<span>User Name: </span><input type="text" name="uname" required/></br>
			<span>Password: </span><input type="password" name="password" required/></br>
			<input type="submit" value="Sign In"/>
			<input type="reset"/>
		</form>
    </div> <!-- #tab-content1 -->
    <div id="tab-content2" class="tab-content">
        <form action="signUp" method="post" enctype="multipart/form-data">
			<div id="account_info">
				<span>Account</span></br>
				<span>User Name: </span><input type="text" name="uname" required/></br>
				<span>Password: </span><input type="password" name="password" required/></br>
			</div>
			<div id="merchant_shop_info">
			<div id="merchant_info">
				<span>Merchant</span></br>
				<span>Name: </span><input type="text" name="mname" required/></br>
				<span>Age: </span><input type="number" name="age" pattern="[0-9]+" required/></br>
				<span>Gender: </span><input type="radio" value="M" checked="checked" class="genderRadio" name="gender"/><span>Male </span><input type="radio" value="F" class="genderRadio" name="gender"/><span>Female </span></br>
			</div>
			<div id="shop_info">
				<span>Shop</span></br>
				<span>Shop Name: </span><input type="text" name="shopName" required/></br>
				<span>Shop Address: </span><input type="text" name="address" required/></br>
				<span>Tel. No: </span><input type="text" name="telno" pattern="[0-9]+" required/></br>
				<span>Upload Shop Logo: </span><input type="file" name="slogo" pattern=".+(.jpg|.png|.gif|.jepg)" required/></br>
			</div>
			</div>
			<div id="signup_submit">
				<input type="submit" value="Sign Up"/>
				<input type="reset"/>
			</div>
		</form>
    </div> <!-- #tab-content2 -->
</div>
<div id="${msgType }" class="centre">
${msg }
</div>
</body>
</html>