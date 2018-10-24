package dao;

import model.Course;

import java.sql.SQLException;

public interface CreateNewCourseDao {
    int createNewCourse(Course course) throws SQLException;
}
