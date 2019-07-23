package com.lambdaschool.school;


import com.lambdaschool.school.model.*;
import com.lambdaschool.school.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    RoleRepository rolerepos;
    UserRepository userrepos;
    InstructorRepository instructrepos;
    StudentRepository studentRepository;
    CourseRepository courseRepository;


    public SeedData(RoleRepository rolerepos, UserRepository userrepos, InstructorRepository instructrepos,
                    CourseRepository courseRepository,StudentRepository studentRepository)
    {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
        this.instructrepos = instructrepos;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
//        this.studCoursesRepository = studCoursesRepository;
    }

    @Override
    public void run(String[] args) throws Exception {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");

        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));

        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));

        rolerepos.save(r1);
        rolerepos.save(r2);
        User u1 = new User("barnbarn", "ILuvM4th!", users);


        User u2 = new User("admin", "password", admins);

        userrepos.save(u1);
        userrepos.save(u2);







//        Student s2 = new Student("Julian");
//        s2.setStudid(2);
//        studentRepository.save(s2);
//        Student s3 = new Student("Mary");
//        s3.setStudid(3);
//        studentRepository.save(s3);
//        Student s4 = new Student("Tyler");
//        s4.setStudid(4);
//        studentRepository.save(s4);
//        Student s5 = new Student("Kim");
//        s5.setStudid(5);
//        studentRepository.save(s5);
//        Student s6 = new Student("Juan");
//        s6.setStudid(6);
//        studentRepository.save(s6);
//        Student s7 = new Student("Robby");
//        s7.setStudid(7);
//        studentRepository.save(s7);
//        Student s8 = new Student("Bob");
//        s8.setStudid(8);
//        studentRepository.save(s8);




        Instructor i1 = new Instructor("Sally");

//        i1.getCourses().add(c1);
//        Instructor i2 = new Instructor("Lucy");
//        i2.setInstructid(2);
//        Instructor i3 = new Instructor("Charlie");
//        i3.setInstructid(3);

        instructrepos.save(i1);
//        instructrepos.save(i2);
//        instructrepos.save(i3);

        //you cannot do auditing with a SQL file.  Dates  and other fields
        // for AUDIT logs will come up as NULL.
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Course> coursesStudCourses = new ArrayList<>();


//seems like studcourse construtor needs to be used in order to have audit fields populate

        Course c1 = new Course("Data Science",i1,students);
        Student s1 = new Student("John", courses);



        s1.getCourses().add(c1);
        c1.getStudents().add(s1);




        StudCourses auditStudCourses = new StudCourses(s1,c1);

        studentRepository.save(s1);
        courseRepository.save(c1);







    }
}
