<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri ="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Subscriber Management</title>
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/rechTabl.css">
</head>
<body>
	<h2>Liste Emprunteur</h2>
	<a href="<c:url value ="/Book"/>"><input id="btnBook"  type="button" value="Mode livre"></a>
		<a href="<c:url value ="/Library"/>"><input id="btnLib"  type="button" value="Mode Bibliotheque"></a>
	
		<Label id="txDel"><c:out value="${fisrtName}"/> <c:out value="${lastName}"/> ${info}</Label>
	<br>
	<br>
	<table border ="1">
		
			<tr>
			<th>ID</th>
			<th>NOM</th>
			<th>PRENOM</th>
			<th>Nbr Emprunt</th>
			</tr>
			<c:forEach var="mySub" items="${emprunteur}">
			<tr>
				<td><c:out value="${mySub.id}"/></td>
				<td><c:out value="${mySub.lastName}"/></td>
				<td><c:out value="${mySub.fisrtName}"/></td>
				<td><c:out value="${mySub.nbrEmprunt}"/></td>
				<td><a href="<c:url value="/Subscriber/modifySub?id=${mySub.id}"/>">Modifier</a></td>
				<td><a id="delSub" href="<c:url value="/Subscriber/deleteSub?id=${mySub.id}"/>">Suprimer</a></td>
				<td><a href="<c:url value="/Subscriber/infoSub?id=${mySub.id}"/>">Info</a></td>
				</tr>
				</c:forEach>
		</table>
		<br>
		<br>
		<a href="<c:url value ="/"/>"><input id= "btnReset" type="button" value="reset" ></a>
		<a href="<c:url value ="/Subscriber/addSub"/>"><input id="btnAddSub"  type="button" value="Ajout Personne"></a>
<br>
<br>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/sub.js"></script>
</body>
</html>