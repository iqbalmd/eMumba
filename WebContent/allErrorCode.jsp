<%@page isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
</head>
<body>
	<c:choose>
		<c:when test="${pageContext.errorData.statusCode == 400}">
			<p>
				<b>Error code:</b>${pageContext.errorData.statusCode}<br> <b>Message:</b>Bad
				Request<br> <b>Description:</b>The server did not understand
				the request<br>
			</p>
		</c:when>
		<c:when test="${pageContext.errorData.statusCode == 403}">
			<b>Error code:</b>${pageContext.errorData.statusCode}<br>
			<b>Message:</b>Bad Forbidden<br>
			<b>Description:</b>Access is forbidden to the requested page.<br>
		</c:when>

		<c:when test="${pageContext.errorData.statusCode == 404}">
			<b>Error code:</b>${pageContext.errorData.statusCode}<br>
			<b>Message:</b>Not Found<br>
			<b>Description:</b>The server can not find the requested page.<br>
		</c:when>

		<c:when test="${pageContext.errorData.statusCode == 405}">
			<b>Error code:</b>${pageContext.errorData.statusCode}<br>
			<b>Message:</b>Method Not Allowed<br>
			<b>Description:</b>The method specified in the request is not allowed.<br>
		</c:when>

		<c:when test="${pageContext.errorData.statusCode == 500}">
			<b>Error code:</b>${pageContext.errorData.statusCode}<br>
			<b>Message:</b>Internal Server Error<br>
			<b>Description:</b>The request was not completed. The server met an unexpected condition.<br>
		</c:when>

	</c:choose>

	<p>
		<b>Request URI:</b>
		${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI}
	</p>
	<br />
	<a href='${pageContext.request.contextPath}/j_spring_security_logout'>Back</a>	
</body>
</html>