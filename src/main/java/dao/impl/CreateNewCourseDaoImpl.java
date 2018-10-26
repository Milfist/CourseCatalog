package dao.impl;

import dao.CreateNewCourseDao;
import dao.JdbcBaseDao;
import model.Course;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateNewCourseDaoImpl implements CreateNewCourseDao {

    private static final StringBuilder CREATE_NEW_COURSE =  new StringBuilder("INSERT ")
            .append("INTO COURSE ")
            .append("(TITLE, DURATION, IS_ACTIVE, COURSE_LEVEL) ")
            .append("VALUES ")
            .append("(?,?,?,?)");

    private JdbcBaseDao jdbcBaseDao;

    public CreateNewCourseDaoImpl(JdbcBaseDao jdbcBaseDao) {
        this.jdbcBaseDao = jdbcBaseDao;
    }

    @Override
    public int createNewCourse(Course course) throws SQLException{
        PreparedStatement preparedStatement = jdbcBaseDao.getPreparedStatement(CREATE_NEW_COURSE.toString());
        preparedStatement.setString(1, course.getTitle());
        preparedStatement.setInt(2, course.getNumberHours());
        preparedStatement.setBoolean(3, course.getActive());
        preparedStatement.setString(4, course.getLevel().name());
        return preparedStatement.executeUpdate();
    }
}
