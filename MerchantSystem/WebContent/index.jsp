<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Merchant System</title>
<style>
	@keyframes msgAnimation {
	    from {
	    	opacity: 1;
	    	display: block;
	    }
	    to {
	    	opacity: 0;
	    	display: none;
		}
	}
	@-webkit-keyframes msgAnimation {
	    from {
	    	opacity: 1;
	    	display: block;
	    }
	    to {
	    	opacity: 0;
	    	disply: none;
		}
	}
	
	#errorMsg {
	    position: absolute;
	    width: 200px;
	    height: 100px;
	    background-color: red;
	    color: white;
	    
	    animation-name: msgAnimation;
	    animation-duration: 2s;
	    animation-delay: 4s;
	    animation-fill-mode: forwards;  
	    -webkit-animation-name: msgAnimation;
	    -webkit-animation-delay: 4s;
    	-webkit-animation-duration: 2s;
    	-webkit-animation-fill-mode: forwards; 
	}
	
	#succMsg{
		position: absolute;
	    width: 200px;
	    height: 100px;
	    background-color: green;
	    color: white;
	    
	    animation-name: msgAnimation;
	    animation-duration: 2s;
	    animation-delay: 4s;
	    animation-fill-mode: forwards; 
	     
	    -webkit-animation-name: msgAnimation;
	    -webkit-animation-delay: 4s;
    	-webkit-animation-duration: 2s;
    	-webkit-animation-fill-mode: forwards;
	}
	
	.centre{
	    top: 50%;
	    left: 50%;
	    transform: translate(-50%,-50%);
	}
	
	
</style>
</head>
<body>

<div id="login">
<form action="login" method="post">
	<label>User Name: </label><input type="text" name="uname" required/></br>
	<label>Password: </label><input type="password" name="password" required/></br>
	<input type="submit" value="Sign In"/>
	<input type="reset"/>
</form>
</div>
	<div id="signup">
	<form action="signUp" method="post" enctype="multipart/form-data">
	<div id="account_info">
		<label>Account</label></br>
		<label>User Name: </label><input type="text" name="uname" required/></br>
		<label>Password: </label><input type="password" name="password" required/></br>
	</div>
	<div id="merchant_shop_info">
	<div id="merchant_info">
		<label>Merchant</label></br>
		<label>Name: </label><input type="text" name="mname" required/></br>
		<label>Age: </label><input type="number" name="age" pattern="[0-9]+" required/></br>
		<label>Gender: </label><input type="radio" value="M" checked="checked" name="gender"/><label>Male </label><input type="radio" value="F" name="gender"/><label>Female </label></br>
	</div>
	<div id="shop_info">
		<label>Shop</label></br>
		<label>Shop Name: </label><input type="text" name="shopName" required/></br>
		<label>Shop Address: </label><input type="text" name="address" required/></br>
		<label>Tel. No: </label><input type="text" name="telno" pattern="[0-9]+" required/></br>
		<label>Upload Shop Logo: </label><input type="file" name="slogo" pattern=".+(.jpg|.png|.gif|.jepg)" required/></br>
	</div>
	</div>
	<div id="signup_submit">
		<input type="submit" value="Sign Up"/>
		<input type="reset"/>
	</div>
</form>
</div>
<div id="${msgType }" class="centre">
${msg }
</div>
</body>
</html>