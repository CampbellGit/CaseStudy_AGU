<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Liste d'utilisateurs</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css">
</head>
<body>
	<div id="formUserss">
		<f:form modelAttribute="user" method="post" action="saveOrUpdateUser">
			<table>
				<tr>
					<th>Nom :</th>
					<td><f:input path="username" /></td>
				</tr>
				<tr>
					<th>Mot de passe:</th>
					<td><f:input path="password" /></td>
				</tr>

				</tr>
				<f:hidden path="id"/>
				<tr>
					<td><input type="submit" value="Save"></td>
				</tr>
			</table>
		</f:form>
	</div>
	<div id="listUserss">
		<table class="table1">
			<tr>
				<th>NOM</th>
				<th>MOT DE PASSE</th>
			</tr>
			<c:forEach items="${users}" var="p">
				<tr>
					<td>${u.username}</td>
					<td>${u.password}</td>
					<td><a href="deleteUser?id=${u.id}">Supprimer</a></td>
					<td><a href="editUser?id=${u.id}">Modifier</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>