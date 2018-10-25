package dao;

import model.Course;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateNewCourseDaoImpl implements CreateNewCourseDao {

    private static final String CREATE_NEW_COURSE = "INSERT INTO COURSE (TITLE, DURATION, IS_ACTIVE, COURSE_LEVEL)  VALUES (?,?,?,?)";

    private JdbcBaseDao jdbcBaseDao;

    public CreateNewCourseDaoImpl(JdbcBaseDao jdbcBaseDao) {
        this.jdbcBaseDao = jdbcBaseDao;
    }

    @Override
    public int createNewCourse(Course course) throws SQLException{
        PreparedStatement preparedStatement = jdbcBaseDao.getPreparedStatement(CREATE_NEW_COURSE);
        preparedStatement.setString(1, course.getTitle());
        preparedStatement.setInt(2, course.getNumberHours());
        preparedStatement.setBoolean(3, course.getActive());
        preparedStatement.setString(4, course.getLevel().name());
        return preparedStatement.executeUpdate();
    }
}
