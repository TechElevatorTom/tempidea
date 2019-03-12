<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Request A Song!</title>
	</head>
<body>
	<h2>Which song would you like to hear butchered at the hands of amateurs?</h2>
	<form action="request" method="POST">
		<label for="title">Title: </label>
		<input type="text" name="title" id="title_input" />

		<label for="artist">Artist: </label>
		<input type="text" name="artist" id="artist_input" />
	
		<label for="album">Album: </label>
		<input type="text" name="album" id="album_input" />
		
		<input type="submit">
	</form>
</body>
</html>