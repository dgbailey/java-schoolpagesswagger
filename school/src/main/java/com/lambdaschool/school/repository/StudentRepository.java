package com.lambdaschool.school.repository;

import com.lambdaschool.school.model.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long>
{
    List<Student> findByStudnameContainingIgnoreCase(String name,Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO StudCourses(courseid, studid) values (:courseid, :studid)", nativeQuery = true)
    void insertIntoStudCourses(long courseid,long studid);

}
