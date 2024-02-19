<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>City Form</title>
</head>
<body>
<h1>Create a new city in WORLD DB</h1>

<c:if test="${not empty requestScope.violations}">
    <h2>Constraint violations</h2>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Value</th>
        </tr>
        <c:forEach var="v" items="${requestScope.violations}">
            <tr>
                <td><c:out value="${v.propertyPath}"/></td>
                <td><c:out value="${v.message}"/></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<form method="post" action="${pageContext.request.contextPath}/City">
    <div>
        <label for="cityId">City ID:</label>
        <input type="text" id="cityId" name="cityId" value="${empty city ? '' : city.id}" />
    </div>
    <div>
        <label for="cityName">City Name:</label>
        <input type="text" id="cityName" name="cityName" value="${empty city ? '' : city.name}" />
    </div>
    <div>
        <label for="countryCode">Country Code:</label>
        <input type="text" id="countryCode" name="countryCode" value="${empty city ? '' : city.countryCode}" />
    </div>
    <button type="submit">Create City</button>
</form>

</body>
</html>
