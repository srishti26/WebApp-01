<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IMDB Search Engine</title>
</head>
<link href ="bootstrap.css" type = "text/css" rel = "stylesheet">
<body><br><br><br>
<center><h1>IMDB</h1></center>
<br><br>
<form action= "FirstServlet">
<table align="center">
<tr>
<th align="right">List of Movies</th>
<td><input type ="submit" value = "list movies" name="button1" /></td>

</tr>
<tr>
<td><input type ="text" name = "moviename" /></td>
<td colspan ="2" align="right"><input type ="submit" value ="search" name="button2" ></td>
</tr>
</table>
</form>
</body>
</html>