package servlet;


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
//
//        request.setCharacterEncoding("UTF-8");
//        chain.doFilter(request, response);

        request.setAttribute("courses", findAllCoursesService.findAllCourse());
        request.getRequestDispatcher("/WEB-INF/hello.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private FindAllCoursesService getFindAllCoursesServiceInstance(HttpServletRequest request) {
        return new FindAllCoursesServiceImpl(getConnection(request));
    }
}
