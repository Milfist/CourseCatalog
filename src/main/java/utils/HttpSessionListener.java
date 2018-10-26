package utils;

import org.h2.tools.RunScript;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HttpSessionListener implements ServletContextListener, javax.servlet.http.HttpSessionListener {

    private final static String DB_FILE_NAME = "courseDB";

    private String url;
    private Connection globalConnection;

    public void contextInitialized(ServletContextEvent sce) {

        String spath = sce.getServletContext().getInitParameter("h2.database.path");

        boolean exists = new File(spath, DB_FILE_NAME+".mv.db").exists();

        try {
            Class.forName("org.h2.Driver");
            File dbfile = new File(spath, DB_FILE_NAME);
            url = "jdbc:h2:file:" + dbfile.getAbsolutePath().replaceAll("\\\\", "/");
            globalConnection = openConnection();
            if (!exists) {
                initDb();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        try {
            globalConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sessionCreated(HttpSessionEvent se) {
        try {
            se.getSession().setAttribute("h2.connection", openConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        try {
            Connection con = (Connection)se.getSession().getAttribute("h2.connection");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initDb() throws SQLException, IOException {
        try (Connection connection = openConnection()) {
            File script = new File(getClass().getResource("/data.sql").getFile());
            RunScript.execute(connection, new FileReader(script));
        }
    }

    private Connection openConnection() throws SQLException {
        return DriverManager.getConnection(url, "sa", "sa");
    }
}
