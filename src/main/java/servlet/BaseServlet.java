package servlet;

import utils.ConnectionSingleton;

import javax.servlet.http.HttpServletRequest;

public interface BaseServlet {
    default void extractConnectionFromHttpSession(HttpServletRequest request) {
        ConnectionSingleton.init(request);
    }
}
