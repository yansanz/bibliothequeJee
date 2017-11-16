<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri ="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/rechTabl.css">
<title>Modifier Exemplaire Livre</title>
</head>
<body>
<h2>Modifier exemplaire</h2>
<br>

<a href="<c:url value ="/Book"/>"><input id= "btnBook" type="button" value="Mode Livre" ></a>
	<a href="<c:url value ="/Library"/>"><input id= "btnLib" type="button" value="Mode Librairie" ></a>
		<input name="isbn"  id="addIsbn" value="${isbn}" type="hidden" size="20">
		
		<br>
		<br>
		<table border ="1">
			<tr>
			<th>ISBN</th>
			<th>Titre</th>
			<th>Sous titre</th>
			<th>Auteur</th>
			<th>numCopy</th>
			<th>Dispo</th>
			
			<th></th>
			</tr>
			<c:forEach var="myCopy" items="${exemplaire}">
			
			<tr>
				<td><c:out value="${myCopy.isbn}"/></td>
				<td><c:out value="${myCopy.title}"/></td>
				<td><c:out value="${myCopy.subtitle}"/></td>
				<td><c:out value="${myCopy.author}"/></td>
				<td><c:out value="${myCopy.numCopy}"/></td>
				<td><c:out value="${myCopy.dispo}"/></td>
			
				<td><a href="<c:url value="/Book/delete?isbn=${myCopy.isbn}&numCopy=${myCopy.numCopy}"/>">Supprimer</a></td>
				<td><a href="<c:url value="/Book/add?isbn=${myCopy.isbn}"/>">Ajouter</a></td>
				<td><a href="<c:url value="/Book/modifyInf?isbn=${myCopy.isbn}&info=${myCopy.numCopy}"/>">info</a></td></tr>
				</c:forEach>
		</table>
		<br>
		<fieldset id="infoZon">
	<legend>INFO EMPRUNTEUR: </legend>
		<Label id="txXarningInfo"> ${emprunteur} ${infoDelete}</Label>
	</fieldset>
			<br>
			<a href="<c:url value ="/Book/modify"/>"><input id= "btnReset" type="button" value="reset" ></a>
		
</body>
<footer>
	<jsp:include page="/Footer.jsp"></jsp:include>
</footer>
</html>