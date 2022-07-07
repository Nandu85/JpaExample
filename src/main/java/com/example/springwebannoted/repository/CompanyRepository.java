package com.example.springwebannoted.repository;

import com.example.springwebannoted.Company;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Integer> {

    List<Company> findCompanyByComNameStartsWith(String s);

    List<Company> findCompanyByComNameContains(String s);

    List<Company> findCompanyByComStrengthGreaterThanEqualOrderByComIdDesc(int i);


}
