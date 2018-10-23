package servlet;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

public interface BaseServlet {
    default Connection getConnection(HttpServletRequest request) {
        return (Connection) request.getSession().getAttribute("h2.connection");
    }
}
