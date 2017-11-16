<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib uri ="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultat Recherche Livre</title>
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/rechTabl.css">

</head>
<body>
	<h2>Liste Livre</h2>
	<hr>
	<a href="<c:url value ="/Book"/>"><input id= "btnReset" type="button" value="reset" ></a>
	<a href="<c:url value ="/Subscriber"/>"><input id="btnSub" type="button" value="Mode Emprunteur"></a>
	<a href="<c:url value ="/Library"/>"><input id="btnLib" type="button" value="Mode Librairie"></a>
		<br>
		<br>
		<table border ="1">
		
			<tr>
			<th>ISBN</th>
			<th>Titre</th>
			<th>Sous Titre</th>
			<th>Auteur</th>
			<th>Genre</th>
			<th>Nbre Copy</th>
			</tr>
			<c:forEach var="myBook" items="${livre}">
			<tr>
				<td><c:out value="${myBook.isbn}"/></td>
				<td><c:out value="${myBook.title}"/></td>
				<td><c:out value="${myBook.subtitle}"/></td>
				<td><c:out value="${myBook.author}"/></td>
				<td><c:out value="${myBook.genre}"/></td>
				<td><c:out value="${myBook.nbrCopy}"/></td>
				<td><a href="<c:url value="/Book/modify?isbn=${myBook.isbn}"/>">Modifier</a></td>
				</tr>
				</c:forEach>
		</table>
		<br>
			<br>
		
	
		

		<br>
</body>
<footer>
	<jsp:include page="/Footer.jsp"></jsp:include>
</footer>
</html>