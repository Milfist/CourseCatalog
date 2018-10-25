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

@WebServlet(name="courseServlet",  urlPatterns = "/courses")
public class CourseServlet extends HttpServlet implements BaseServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FindAllCoursesService findAllCoursesService = getFindAllCoursesServiceInstance(request);
        request.setAttribute("courses", findAllCoursesService.findAllCourse().isPresent());
        request.getRequestDispatcher("/WEB-INF/courses.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (checkParameterView(request)) {
            request.getRequestDispatcher("/WEB-INF/newCourse.jsp").forward(request, response);
        } else {
            CreateNewCourseService createNewCourseService = getCreateNewCourseServiceInstance(request);
            createNewCourseService.createNewCourse(createNewCourseInstanceWithRequestParameters(request));
            doGet(request, response);
        }
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
                translateCheckBoxValueToBoolean(request.getParameter("active")),
                translateParameterToLevel(request.getParameter("level")));

    }

    private boolean translateCheckBoxValueToBoolean(String checkBoxValue) {
        return checkBoxValue.equals("on");
    }

    private Level translateParameterToLevel(String parameter) {
        return Level.valueOf(parameter.toUpperCase());
    }

    private boolean checkParameterView(HttpServletRequest request) {
        return null != request.getParameter("view") && request.getParameter("view").equals("newCourseView");
    }
}
