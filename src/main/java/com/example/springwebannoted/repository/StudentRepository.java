package com.example.springwebannoted.repository;

import com.example.springwebannoted.Book;
import com.example.springwebannoted.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student,Long> {

    List<Student> findStudentByNameContaining(String s);

    List<Student> findStudentByAddress_Zip/*OrderBySIdDesc*/(String zip, Sort sort);

//    List<Student> findByBooks(List<Book> b);
}
