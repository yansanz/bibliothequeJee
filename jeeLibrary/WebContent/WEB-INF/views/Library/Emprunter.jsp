<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri ="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/libraryStyle.css">
<title>Mode Librairie</title>
</head>
<body>
	<h2>Liste Exemplaire</h2>
	<br>
	<label >Seul les ref N°1 sont dispo</label>
	<br>
	<form action="validEmprunt" method="get">
			<select id="box" name="book" >
				<option > </option>
				<c:forEach var="myBook" items="${livre}">
				<option ><c:out value="${myBook.dispo}"/> <c:out value="${myBook.numCopy}"/> <c:out value="${myBook.isbn}"/> <c:out value="${myBook.title}"/> </option>
				</c:forEach>
				</select>
				<hr>
				<br>
				<h2>Emprunteur</h2>
				<input name="txtId" type="hidden" value="${id}"></input>
				<label >Nom</label>
				<input id ="txtP" name="txtNom" value="${lastName}" type="text" size="20">
				<label >Prenom</label>
				<input id ="txtN" name="txtPrenom" value="${fisrtName}" type="text" size="20">
				<br>
				<br>
				<br>
					<a href="<c:url value ="/"/>"><input id="btnReset" type="button" value="reset" ></a>
				<input id="btnValid"type="submit" value="valider">
				</form>
				
</body>
</html>