<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function validate() {
	
	var name = document.getElementById("name");
	var email = document.getElementById("email");
	var password = document.getElementById("password");
	var msg = "";
	if(name != null && name.value == ""){
			msg += " NAME";			
	}
	if(email != null && email.value == ""){
		msg += " EMAIL";			
	}
	if( password != null && password.value == ""){
		msg += " PASSWORD";
	}
	
	if(msg != ""){
		alert("Please enter the "+msg);
		return false;
	} else {
		return true;
	}	
}
</script>
<title>Create a New User</title>
</head>
<body>
	<h4>${message}</h4>
	Fill the following form to create a new User.
	<p>
	<form name='form1' action='${pageContext.request.contextPath}/secured/create' method='POST'>
		<table border="1" cellpadding="1" cellspacing="1">
			<tr>
				<td>User Name:</td>
				<td><input type='text' name='username' value='' id="name"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name='email' id="email"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' id="password"/></td>
			</tr>
			<tr>
				<td>Autority:</td>
				<td><select name="authority">
						<option value="ROLE_NORMAL" selected>Normal User</option>
						<option value="ROLE_ADMIN">Administrative</option>
				</select></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="Create" onclick="return validate()"/></td>
				<td><input name="clear" type="reset" value="Clear"/></td>
			</tr>
		</table>
	</form>
	<p><a href='${pageContext.request.contextPath}/home'>Home</a></p>
</body>
</html>