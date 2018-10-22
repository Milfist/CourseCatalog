package servlet;


import service.FindAllCoursesService;
import service.FindAllCoursesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name="course",  urlPatterns = "/courseServlet")
public class CourseServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FindAllCoursesService findAllCoursesService = getFindAllCoursesServiceInstance(request);

        request.setAttribute("courses", findAllCoursesService.findAllCourse());
        request.getRequestDispatcher("/WEB-INF/hello.jsp").forward(request, response);
    }

    private FindAllCoursesService getFindAllCoursesServiceInstance(HttpServletRequest request) {
        return new FindAllCoursesServiceImpl((Connection) request.getSession().getAttribute("h2.connection"));
    }
}
