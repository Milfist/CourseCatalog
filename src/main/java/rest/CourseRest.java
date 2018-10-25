package rest;


import model.Course;
import model.Level;
import service.FindAllCoursesService;
import service.FindAllCoursesServiceImpl;
import servlet.BaseServlet;
import utils.JsonConverter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name="course",  urlPatterns = "/course")
public class CourseRest extends HttpServlet implements BaseServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        FindAllCoursesService findAllCoursesService = getFindAllCoursesServiceInstance(request);

        response.setContentType("application/json");

        ServletOutputStream out = response.getOutputStream();

        JsonConverter converter = new JsonConverter();
        String output = converter.convertToJson(findAllCoursesService.findAllCourse().orElse(new ArrayList<>()));

        out.print(output);



    }

    private FindAllCoursesService getFindAllCoursesServiceInstance(HttpServletRequest request) {
        return new FindAllCoursesServiceImpl(getConnection(request));
    }
}