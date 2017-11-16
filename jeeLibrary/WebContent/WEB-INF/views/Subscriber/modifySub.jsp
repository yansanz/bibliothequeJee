<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri ="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/rechBook.css">
<title>Modifier Emprunteur</title>
</head>
<body>
<h2 id= "titrModifSub">Modifier Emprunteur</h2>
	<hr>
	<form action="formModifSub" method="get">
	<div id="champRech">
		<br>
				<input name="txtId" type="hidden" value="${id}"></input>
				<label >Nom</label>
				<br>
				<br>
				<input id="txtNom" name="txtNom" value="${lastName}" type="text" size="20">
					<br>
				<br>
		<br>
				<label >Prenom</label>
				<br>
				<br>
				<input id="txtPrenom" name="txtPrenom" value="${fisrtName}" type="text" size="20">
			
				<br>
				<br>
				</div>
				<a href="<c:url value ="/"/>"><input id= "btnReset" type="button" value="reset" ></a>
			<input id ="btnValid" type="submit" value="valider">
			</form>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/modifSub.js"></script>
</body>
</html>