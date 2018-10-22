<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>Hello World</h1>
    <c:forEach var="course" items="${courses}">
        <div>
            <p>Message: ${course.title}</p>
            <p>Message: ${course.numberHours}</p>
            <p>Message: ${course.active}</p>
            <p>Message: ${course.level}</p>
        </div>
    </c:forEach>
</body>
</html>