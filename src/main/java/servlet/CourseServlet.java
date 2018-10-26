package servlet;


import model.Course;
import model.Level;
import service.*;
import service.impl.CreateNewCourseServiceImpl;
import service.impl.FindActiveCoursesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="courseServlet",  urlPatterns = "/courses")
public class CourseServlet extends HttpServlet implements BaseServlet, AbstractServiceFactory {

    @Override
    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FindObjectInDaoCallService findCoursesService = newFindObjectService(request);
        request.setAttribute("courses", findCoursesService.findObjectInDaoCall().orElse(new ArrayList<>()));
        request.getRequestDispatcher("/WEB-INF/courses.jsp").forward(request, response);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (checkParameterView(request)) {
            request.getRequestDispatcher("/WEB-INF/newCourse.jsp").forward(request, response);
        } else {
            CreateNewObjectInDaoCallService createNewObjectInDaoCallService = newCreateNewObjectService(request);
            createNewObjectInDaoCallService.createNewObjectInDaoCall(createNewCourseInstanceWithRequestParameters(request));
            doGet(request, response);
        }
    }

    @Override
    public FindObjectInDaoCallService newFindObjectService(HttpServletRequest request) {
        return new FindActiveCoursesServiceImpl(getConnection(request));
    }

    @Override
    public CreateNewObjectInDaoCallService newCreateNewObjectService(HttpServletRequest request) {
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
