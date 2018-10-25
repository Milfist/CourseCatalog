package servlet;


import model.Course;
import model.Level;
import service.CreateNewCourseService;
import service.CreateNewCourseServiceImpl;
import service.FindAllCoursesService;
import service.FindAllCoursesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="courseServlet",  urlPatterns = "/courses")
public class CourseServlet extends HttpServlet implements BaseServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FindAllCoursesService findAllCoursesService = getFindAllCoursesServiceInstance(request);
        request.setAttribute("courses", findAllCoursesService.findAllCourse().get());
        request.getRequestDispatcher("/WEB-INF/courses.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        if (null != request.getParameter("param") && request.getParameter("param").equals("newCourseView")) {
            request.getRequestDispatcher("/WEB-INF/newCourse.jsp").forward(request, response);
        } else {
            CreateNewCourseService createNewCourseService = getCreateNewCourseServiceInstance(request);
            createNewCourseService.createNewCourse(createNewCourseInstanceWithRequestParameters(request));
            doGet(request, response);
        }

//        if(createNewCourseService.createNewCourse()) {
//
//        }

    }

    private FindAllCoursesService getFindAllCoursesServiceInstance(HttpServletRequest request) {
        return new FindAllCoursesServiceImpl(getConnection(request));
    }

    private CreateNewCourseService getCreateNewCourseServiceInstance(HttpServletRequest request) {
        return new CreateNewCourseServiceImpl(getConnection(request));
    }

    private Course createNewCourseInstanceWithRequestParameters(HttpServletRequest request) {
        return new Course(request.getParameter("title"),
                Integer.parseInt(request.getParameter("duration")),
                translateBooleanParameter(request.getParameter("active")),
                translateLevelParameter(request.getParameter("level")));

    }

    private boolean translateBooleanParameter(String parameter) {
        return parameter.equals("on") ? true : false;
    }

    private Level translateLevelParameter(String parameter) {
        return Level.valueOf(parameter.toUpperCase());
    }
}
