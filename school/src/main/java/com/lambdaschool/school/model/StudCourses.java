package com.lambdaschool.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "studcourses")
public class StudCourses extends Auditable implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"studCourses", "hibernateLazyInitializer"})
    @JoinColumn(name = "studid")
    private Student student;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"studCourses", "hibernateLazyInitializer"})
    @JoinColumn(name = "courseid")
    private Course course;

    public StudCourses() {
    }

    public StudCourses(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof StudCourses))
        {
            return false;
        }
        StudCourses userRoles = (StudCourses) o;
        return getStudent().equals(userRoles.getStudent()) && getCourse().equals(userRoles.getStudent());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getStudent(), getCourse());
    }
}
