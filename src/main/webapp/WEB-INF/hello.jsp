<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
    <h1>Cursos</h1>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">Titulo</th>
          <th scope="col">Duraci&oacute;n</th>
          <th scope="col">Activo</th>
          <th scope="col">Nivel</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="course" items="${courses}">
            <tr>
              <th scope="row">${course.title}</th>
              <td>${course.numberHours}</td>
              <td>${course.active}</td>
              <td>${course.level}</td>
            </tr>
        </c:forEach>
      </tbody>
    </table>
</body>
</html>