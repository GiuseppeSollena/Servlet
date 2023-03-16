<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

     <h1>LOGIN PAGE</h1>
    <form action="${pageContext.request.contextPath}/LoginServlet" method="POST">
        <input type="text" name="username" placeholder="inserisci username">
        <input type="password" name="password" placeholder="inserisci password">
        <input type="submit" value="accedi">
    </form>

</body>
</html>