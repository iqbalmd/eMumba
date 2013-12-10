<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Landing Page</title>
</head>
<body>
	<h3>This is Landing page.</h3>
	<p>Welcome: ${message}</p>
	<security:authorize access="hasRole('ROLE_ADMIN')">
		<a href='<c:out value="${pageContext.request.contextPath}/secured/allusers"></c:out>'>All Users</a>
	</security:authorize>
	<!-- <a href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a> -->
	<a href='<c:out value="${pageContext.request.contextPath}/j_spring_security_logout"></c:out>'>Logout</a>
</body>
</html>