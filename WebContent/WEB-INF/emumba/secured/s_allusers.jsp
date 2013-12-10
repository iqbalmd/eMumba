<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<html>
<title>All User Page</title>
<head>
<script type="text/javascript">
function confirmDelete() {
	if(confirm("Are you sure to delete the user?")){
		return true;
	}else{
		return false;
	}
	
}
</script>
</head>
<body>

	<h4>${message}</h4>

	<security:authorize access="hasRole('ROLE_ADMIN')">
		<p>For creating a new User click the following </p>
		<p><a href='${pageContext.request.contextPath}/secured/createNewUser'>Create New user</a></p>
		<table border="1">
		<tr>
			<th>Name</th>
			<th>Password</th>
			<th>Privilege</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.name}"/></td>
					<td><c:out value="${user.email}"/></td>
					<td>
						<c:choose>
							<c:when test="${user.authority == 'ROLE_ADMIN'}">
								<c:out value="Administrative"/>
							</c:when>
							<c:when test="${user.authority == 'ROLE_NORMAL'}">
								<c:out value="Normal User"/>
							</c:when>
							<c:otherwise>
								<c:out value="Unknown Type"/>
							</c:otherwise>
						</c:choose>						
					</td>
					<td><a href='${pageContext.request.contextPath}/secured/deleteUser/${user.id}' onclick="return confirmDelete();">Delete</a></td>
					<td><a href='${pageContext.request.contextPath}/secured/update/${user.id}'>Update</a></td>
				</tr>
			</c:forEach>
		</table>
	</security:authorize>
	<p><a href='${pageContext.request.contextPath}/home'>Home</a></p>
</body>
</html>