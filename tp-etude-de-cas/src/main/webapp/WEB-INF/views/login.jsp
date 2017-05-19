<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <c:url var="loginUrl" value="/login" />
<form action="${loginUrl}" method="post" class="form-horizontal">
		<table>
			<tr>
				<th colspan="2">Test Login customisé</th>
			</tr>
			<tr>
				<td>Login</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Pass word</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>

</body>
</html>