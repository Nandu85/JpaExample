package com.example.springwebannoted;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        List<String> results = entityManager.createQuery("select u.credential.username from UserObject u").getResultList();



        System.out.println(results);

//        for (int i=1;i<=11;i++){
//            UserObject user = new UserObject();
//
//            UserCredential credential = new UserCredential("java"+i,"javax"+i+"@naeolan.emal");
//
//            user.setContactNo("2323232853"+i+i);
//
//            user.setCredential(credential);
//            entityManager.persist(user);
//        }
//
            for (int i=1;i<=11;i++){
                Company company = new Company("nar_b"+i,"nar"+i+"owned",2.56+i/2,50*i);

                entityManager.persist(company);
            }

//        Address address = new Address();
//        address.setCity("ahemdabad");
//        address.setState("Gujarat");
//        address.setCountry("India");
//        address.setStreet("Manek Chawk");
//        address.setZip("325645");
//
//        Student student = entityManager.find(Student.class, 6l);

        System.out.println();
//        Student student6 = entityManager.find(Student.class, 10l);
//        student.setAddress(address);
//        List<Book> bookList = student6.getBooks();
//        System.out.println(bookList);
//
//        for (Book b:bookList) {
//            b.setStudent(student);
//
//        }
//        bookList.remove(2);
//        bookList.remove(0);
//        student6.setBooks(bookList);
//        System.out.println(bookList);
//        entityManager.persist(student);
//        entityManager.persist(student6);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();


    }
}
