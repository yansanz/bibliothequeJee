<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri ="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library</title>
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/index.css">
</head>
<body>
<div id = "gallery2">
	<img  src="img/elroy4.jpeg">
	
	<img  src="img/clancy2.jpeg">
	<img  src="img/elroy 5.jpeg">
		<img  src="img/elroy2.jpeg">
	<img  src="img/lehane2.jpeg">
	</div>
	<a href="<c:url value ="/Book"/>"><input id="enter"  type="button" value=""></a>
	<div id = "gallery">
	
	<img  src="img/elorry.jpeg">
	<img  src="img/clancy.jpeg">
	<img  src="img/elroy3.jpeg">
	<img  src="img/elorry3.jpeg">
	<img  src="img/lehane.jpeg">
	</div>
</body>
</html>