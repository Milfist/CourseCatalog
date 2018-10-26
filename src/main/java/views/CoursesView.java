package views;

import model.Course;

import java.util.List;

public class CoursesView implements View{

    private List<Course> courses;

    public CoursesView(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String getHtml() {
        return createView();
    }

    private String createView(){

        return new StringBuilder()
                .append("<!DOCTYPE html>")
                .append("<html lang=\"en\">")
                .append("<head>")
                .append("    <meta charset=\"UTF-8\">")
                .append("    <title>Title</title>")
                .append("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" ")
                .append("          integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">")
                .append("</head>")
                .append("<body>")
                .append("    <div class=\"w-50 p-3 mx-auto\">")
                .append("        <h1>Cursos</h1>")
                .append("        <table class=\"table\">")
                .append("          <thead>")
                .append("            <tr>")
                .append("              <th scope=\"col\">Titulo</th>")
                .append("              <th scope=\"col\">Duraci&oacute;n</th>")
                .append("              <th scope=\"col\">Nivel</th>")
                .append("            </tr>")
                .append("          </thead>")
                .append("          <tbody>")
                .append(generateHtmlByCourses())
                .append("          </tbody>")
                .append("        </table>")
                .append("        <form action=\"/courses?view=newCourseView\" method=\"POST\">")
                .append("            <div class=\"mx-auto\" style=\"width: 200px;\">")
                .append("                <button type=\"submit\" class=\"btn btn-primary\">Add course</button>")
                .append("            </div>")
                .append("        </form>")
                .append("    </div>")
                .append("</body>")
                .append("</html>")
                .toString();
    }

    private String generateHtmlByCourses() {
        StringBuilder courseHtml = new StringBuilder();

        for (Course course : courses) {
            courseHtml
            .append("                <tr>")
            .append("                  <th scope=\"row\">" + course.getTitle() + "</th>")
            .append("                  <td>" + course.getNumberHours() + "</td>")
            .append("                  <td>" + course.getLevel().name() + "</td>")
            .append("                </tr>");
        }
        return courseHtml.toString();
    }


}
