package com.lambdaschool.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @JsonView(View.CoursesOnly.class)
    private long courseid;

//    @JsonView(View.CoursesOnly.class)
    private String coursename;

    @ManyToOne
    @JoinColumn(name = "instructid")
    @JsonIgnoreProperties("courses")
//    @JsonView(View.CoursesOnly.class)
    private Instructor instructor;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnoreProperties("courses")
    private List<Student> students = new ArrayList<>();

    private StudCourses studCourses;

    public Course()
    {
    }



    public Course(String coursename, Instructor instructor,List<Student> students)
    {
        this.coursename = coursename;
        this.instructor = instructor;
        for (Student s: students)
        {
            s.getCourses().add(this);
        }
        this.students = students;
    }

    public long getCourseid()
    {
        return courseid;
    }

    public void setCourseid(long courseid)
    {
        this.courseid = courseid;
    }

    public String getCoursename()
    {
        return coursename;
    }

    public void setCoursename(String coursename)
    {
        this.coursename = coursename;
    }

    public Instructor getInstructor()
    {
        return instructor;
    }

    public void setInstructor(Instructor instructor)
    {
        this.instructor = instructor;
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }
}
