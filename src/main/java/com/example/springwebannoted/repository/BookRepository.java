package com.example.springwebannoted.repository;

import com.example.springwebannoted.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book,Long> {

//    List<Book> getByFirst5();
//    List<Book> fin

}
