package rest;


import model.Course;
import model.Level;
import utils.JsonConverter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="course",  urlPatterns = "/course")
public class CourseRest extends HttpServlet {
    private String message;

    /*@Override
    public void init() throws ServletException {
        // Do required initialization
        message = "Hello World";
    }*/

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        // Set response content type
        response.setContentType("application/json");
//
//        // Actual logic goes here.
//        PrintWriter out = response.getWriter();
//        out.println("<h1>" + message + "</h1>");

//        request.setAttribute("course", new Course("Java", 100, true, Level.ADVANCED));
//        request.getRequestDispatcher("/WEB-INF/courses.jsp").forward(request, response);

//        response.setContentType("application/json;charset=UTF-8");

        ServletOutputStream out = response.getOutputStream();

        JsonConverter converter = new JsonConverter();
        String output = converter.convertToJson(new Course("Java", 100, true, Level.ADVANCED));

        out.print(output);



    }

    /*@Override
    public void destroy() {
        // do nothing.
    }*/
}