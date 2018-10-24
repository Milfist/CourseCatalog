package servlet;


import model.Course;
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

@WebServlet(name="course",  urlPatterns = "/courseServlet")
public class CourseServlet extends HttpServlet implements BaseServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FindAllCoursesService findAllCoursesService = getFindAllCoursesServiceInstance(request);
        request.setAttribute("courses", findAllCoursesService.findAllCourse().get());
        request.getRequestDispatcher("/WEB-INF/hello.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CreateNewCourseService createNewCourseService = getCreateNewCourseServiceInstance(request);

//        Course course = new Course(request.getParameter("title"), request.getParameter("duration"), request.getParameter("active"), request.getParameter("level"));
        request.getParameter("title");
        request.getParameter("duration");
        request.getParameter("active");
        request.getParameter("level");


        if(createNewCourseService.createNewCourse()) {

        }

    }

    private FindAllCoursesService getFindAllCoursesServiceInstance(HttpServletRequest request) {
        return new FindAllCoursesServiceImpl(getConnection(request));
    }

    private CreateNewCourseService getCreateNewCourseServiceInstance(HttpServletRequest request) {
        return new CreateNewCourseServiceImpl(getConnection(request));
    }


}
