package com.example.springwebannoted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @RequestMapping(value = "jpa-persist", method = RequestMethod.GET)
    public ResponseEntity<String> transactionToDB(@RequestParam String name,@RequestParam String course) {

        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Student student = new Student();
        student.setName(name);
        student.setCourse(course);
        manager.persist(student);
//        transaction.commit();

        manager.flush();
        System.out.println(manager.find(Student.class,1));
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "jpa-foreignkey", method = RequestMethod.GET)
    public ResponseEntity<String> addStudent(@RequestParam String name,@RequestParam String course) {

        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Student studentX = manager.find(Student.class,1);
        studentX.setName("Hello");

        Book book2=new Book();
        book2.setBookName("Java1");
        book2.setCreatedOn(new Date());

        List<Book> books = new ArrayList<>();
        books.add(book2);

        Book book1=new Book();
        book1.setBookName("Java1");
        book1.setCreatedOn(new Date());
        books.add(book1);

        Student student = new Student();
        student.setName(name);
        student.setCourse(course);
//        student.setBooks(books);

//        book2.setStudent(student);
//        book1.setStudent(student);

        manager.persist(student);
//        manager.merge(student);
        transaction.commit();


        manager.close();
        return ResponseEntity.ok().build();
    }

}
