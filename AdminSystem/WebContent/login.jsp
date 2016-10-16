<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Please login to admin system</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>
<h1>Login</h1>
<br />
<div style="width:600px">
<form action="login" method="post">
	<div class="form-group">
		<div class="input-group"> 
	      <input type="text" class="form-control" name="adminName" placeholder="Input your name here">
	      <div class="input-group-addon">
	      	<input type="submit" value="Go!"/>	      	
	      </div>
	    </div>
	</div>
</form>
</div>
</body>
</html>