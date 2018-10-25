<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
    <div class="w-50 p-3 mx-auto">
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
        <form action="/courses?param=newCourseView" method="POST">
            <div class="mx-auto" style="width: 200px;">
                <button type="submit" class="btn btn-primary">Add course</button>
            </div>

        </form>
    </div>
</body>
</html>