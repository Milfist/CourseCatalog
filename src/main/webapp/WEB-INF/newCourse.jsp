<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Nuevo curso</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
    <div class="w-50 p-3 mx-auto">
        <form action = "/courses?param=add" method = "POST">
            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" class="form-control" id="title" name="title" placeholder="Python for experts">
            </div>
            <div class="form-group">
                <label for="duration">Duration (In hours)</label>
                <input type="number" class="form-control" id="duration" name="duration" placeholder="99">
            </div>
            <div class="form-group">
                <label for="level">Another label</label>
                <select class="form-control" id="level" name="level">
                    <option>Advanced</option>
                    <option>Medium</option>
                    <option>Basic</option>
                </select>
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="active" name="active">
                <label class="form-check-label" for="active">Course is active</label>
            </div>
            <div class="mx-auto" style="width: 270px;">
                <button type="submit" class="btn btn-primary">Add course</button>
                <button type="" class="btn btn-secondary">Go back</button>
                <button type="reset" class="btn btn-secondary">Reset</button>
            </div>
        </form>
    </div>
</body>
</html>
