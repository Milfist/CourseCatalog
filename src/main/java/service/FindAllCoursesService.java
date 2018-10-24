package service;

import model.Course;

import java.util.List;
import java.util.Optional;

public interface FindAllCoursesService {
    Optional<List<Course>> findAllCourse();
}
