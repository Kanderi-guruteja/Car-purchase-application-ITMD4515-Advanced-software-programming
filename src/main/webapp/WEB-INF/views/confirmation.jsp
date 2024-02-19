<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmation</title>
</head>
<body>
<h1>Confirmation</h1>

<c:if test="${not empty requestScope.city}">
    <p>City ID: ${requestScope.city.ID}</p>
    <p>City Name: ${requestScope.city.name}</p>
    <p>Country Code: ${requestScope.city.countryCode}</p>
</c:if>

</body>
</html>
