package utils;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.sql.Connection;

public class ConnectionSingleton implements Serializable {

    private static Connection INSTANCE = null;

    private ConnectionSingleton() {}

    public static void init(HttpServletRequest request) {
        if (INSTANCE == null) {
            INSTANCE = (Connection) request.getSession().getAttribute("h2.connection");
        }
    }

    public static Connection getConecction() {
        return INSTANCE;
    }
}