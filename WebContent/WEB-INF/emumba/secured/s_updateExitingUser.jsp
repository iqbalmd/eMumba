<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Fill change the following form to update the existing User.
	<p>
	<form:form name='form1' commandName="updateUser" action='${pageContext.request.contextPath}/secured/update/${updateUser.id}' method='POST'>
		<table border="1" cellpadding="1" cellspacing="1">
			<tr>
				<td>User Name:</td>
				<td><form:input path="name" id="name"/></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" id="email"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" id="password"/> </td>
			</tr>
			<tr>
				<td>Autority:</td>
				<td>
				<form:select path="authority">
					<form:option value="ROLE_NORMAL">Normal User</form:option>
					<form:option value="ROLE_ADMIN">Administrative</form:option>
				</form:select>				
				</td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit" value="Update" onclick="return validate()"/></td>
			</tr>
		</table>
	</form:form>
	<p><a href='${pageContext.request.contextPath}/home'>Home</a></p>
</body>
</html>