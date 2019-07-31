<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Tom's Band!</title>
	</head>
	<body>
		<c:if test="${thankYou}">
			<p>Thank you for your request!</p>
		</c:if>
		<a href="request">Request a song!</a>
		<h1>Here are all the songs we know:</h1>
		<table border=1>
			<tr>
				<th>Title</th>
				<th>Artist</th>
				<th>COLLECTION</th>
			</tr>
			
			<c:forEach var="song" items="${songs}">
			<tr>
				<td>${song.title}</td>
				<td>${song.artist}</td>
				<td>${song.album}</td>				
			</tr>
			</c:forEach>
		</table>

		<c:if test="${empty songs}">
			<h3>We'd better learn some songs!</h3>
		</c:if>
		
		<h1>Here are all the requests we've received:</h1>
		<table border=1>
			<tr>
				<th>Title</th>
				<th>Artist</th>
				<th>Album</th>
			</tr>
			
			<c:forEach var="song" items="${requests}">
			<tr>
				<td>${song.title}</td>
				<td>${song.artist}</td>
				<td>${song.album}</td>				
			</tr>
			</c:forEach>
		</table>

		<c:if test="${empty requests}">
			<h3>You should request a song!</h3>
		</c:if>
	</body>
</html>