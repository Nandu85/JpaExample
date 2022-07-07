package com.example.springwebannoted;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookid;

    @Column(nullable = false)
    private String bookName;

    @Column(nullable = false)

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

//    @Transient
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "sId")
    private Student student;

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
