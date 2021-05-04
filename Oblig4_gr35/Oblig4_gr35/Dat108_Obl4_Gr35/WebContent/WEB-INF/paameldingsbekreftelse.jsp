<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>
	<p>
		&nbsp;&nbsp;&nbsp;${deltaker.fornavn}<br />
		&nbsp;&nbsp;&nbsp;${deltaker.etternavn}<br />
		&nbsp;&nbsp;&nbsp;${deltaker.mobil}<br /> &nbsp;&nbsp;&nbsp;${deltaker.kjonn}
	</p>
	<a href="deltakerliste">Gå til deltagerlisten</a>
</body>
</html>