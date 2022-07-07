package com.example.springwebannoted;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "default 2")
    private Long sId = 2L;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String course;

    @OneToMany/*(cascade = {CascadeType.PERSIST}),
//            fetch = FetchType.EAGER,
//            orphanRemoval = true,
            mappedBy = "student"*/
    private List<Book> books;

    @Embedded
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    //    @Override
//    public String toString() {
//        return "Student{" +
//                "sId=" + sId +
//                ", name='" + name + '\'' +
//                ", course='" + course + '\'' +
//                '}';
//    }
}
