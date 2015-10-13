<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registeration</title>
</head>
<body>
	<p style="color: red"> ${result}</p>
	<form action="Validatation" name="form" method="post">
		<table align="center">
			<tr> <td>User Name: <input type="text" name="name" placeholder="Enter Name" /></td> </tr>
			<tr> <td>Email: <input type="email" name="email" placeholder="Enter email-id" /></td> </tr>
			<tr><td>Password: <input type="password" name="password" placeholder="Enter password"></td></tr>
			<tr><td>Confirm Password: <input type="password" name="confirmPassword" placeholder="Confirm password"></td></tr>			
			<tr><td><input type="submit" id="submitButton" value="submit"></td></tr>
		</table>
		
	</form>
</body>
</html>