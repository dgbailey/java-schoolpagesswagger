package com.lambdaschool.school.service;

import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.view.CountStudentsInCourses;

import java.util.ArrayList;

public interface CourseService
{
    ArrayList<Course> findAll();

    ArrayList<CountStudentsInCourses> getCountStudentsInCourse();

    void delete(long id);

//    Course findCourseByCourseName (String course);

    Course findByCourseid(long courseid);
}
