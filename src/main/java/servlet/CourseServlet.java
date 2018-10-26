package servlet;


import model.Course;
import model.Level;
import service.FindObjectInDaoCallService;
import service.CreateNewObjectInDaoCallService;
import service.AbstractServiceFactory;
import service.impl.CreateNewCourseServiceImpl;
import service.impl.FindActiveCoursesServiceImpl;
import views.CoursesView;
import views.NewCourseView;
import views.View;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="courseServlet",  urlPatterns = "/courses")
public class CourseServlet extends HttpServlet implements BaseServlet, AbstractServiceFactory {

    @Override
    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FindObjectInDaoCallService findCoursesService = newFindObjectService(request);

        View coursesView = new CoursesView((List<Course>) findCoursesService.findObjectInDaoCall()
                .orElse(new ArrayList<>()));
        writeViewInResponse(response, coursesView);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (checkParameterView(request)) {
            writeViewInResponse(response, new NewCourseView());
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

    private void writeViewInResponse(HttpServletResponse response, View view) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(view.getHtml());
    }
}
