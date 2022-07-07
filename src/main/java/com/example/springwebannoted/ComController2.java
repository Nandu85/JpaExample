package com.example.springwebannoted;

import com.example.springwebannoted.repository.BookRepository;
import com.example.springwebannoted.repository.CompanyRepository;
import com.example.springwebannoted.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ComController2 {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    BookRepository bookRepository;

    @PostMapping("v1/giveCom")
    public ModelAndView giveDetail(/*@RequestBody @Validated Company company,*/ @RequestPart MultipartFile file) throws Exception {
        ModelAndView modelAndView;
        if (file != null && !file.isEmpty()) {
            modelAndView = new ModelAndView("NewJSp");
        } else throw new Exception("Pic Not Found");
        return modelAndView;
    }

    @GetMapping("/v5/rest")
    public ResponseEntity<String> testv5() {
        RestTemplate restTemplate = new RestTemplate();
        Company company = restTemplate.getForObject("http://localhost:8080/SpringWeb_war_exploded/response/getCom", Company.class);
        return ResponseEntity.ok().body("Okay." + company.toString());
    }

    @PostMapping("/v5/rest")
    public ResponseEntity<String> postRest() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED));
        Company cmo = new Company("", "dfgdfgb", 100.2, 50000);
        HttpEntity<Company> comEntity = new HttpEntity<>(cmo);
//        /*ResponseEntity<Company> response = */restTemplate.exchange("http://localhost:8080/SpringWeb_war_exploded/response/addCom", HttpMethod.POST,comEntity,Company.class);
//        String company = String.valueOf(response.getBody());
//        Company str = restTemplate.postForObject(new URI("http://localhost:8080/SpringWeb_war_exploded/response/addCom"),cmo,Company.class);
        ResponseEntity<Company> response = restTemplate.exchange(new URI("http://localhost:8080/SpringWeb_war_exploded/response/addCom"), HttpMethod.POST, comEntity, Company.class);
        Company str = response.getBody();
        return ResponseEntity.ok().body("Okay."/*+company*/ + str);
    }


    @GetMapping("/v6/rest")
    public ResponseEntity<String> testv6() {
        UriComponents components = UriComponentsBuilder.fromUriString("http://localhost:8080/SpringWeb_war_exploded/response/getCom").queryParam("weree", "1234").build();
//        URI uri = components.expand("rgsg","123").toUri();
        URI uri = UriComponentsBuilder.fromUriString("https://example.com/hotels/{hotel}").queryParam("q", "{q}").encode().buildAndExpand("Westin", "123").toUri();
        return ResponseEntity.ok().body("Okay.\n" + components + "\n" + uri);
    }


    @GetMapping("/persistant")
    @Transactional
    public ResponseEntity<List<Company>> persistanceChange() {
//        for (int i=1;i<=11;i++){
//            Company company = new Company("nar_b"+i,"nar"+i+"owned",2.56+i/2,50*i);
//            companyRepository.save(company);

//        }


//        Book book1 = new Book();
//        book1.setBookName("ghijkl");
//        book1.setCreatedOn(new Date());
//
//        Student student = new Student();
//        student.setCourse("JPA");
//        student.setName("Anjulika");
//        student.setAddress(new Address("MK gandhi Road", "Surat", "Gujarat", "India", "395009"));
//
//        book1.setStudent(student);
//        bookRepository.save(book1);
//        System.out.println(studentRepository.findStudentByNameContaining("hij"));

//        System.out.println((companyRepository.findAll(Pageable.ofSize(5))).getTotalPages());
//        List<Company> companies = companyRepository.findAll(PageRequest.of(3,5)).getContent();
        Sort sort = Sort.by("name").descending();
        List<Student> students = studentRepository.findStudentByAddress_Zip/*OrderBySIdDesc*/("395009",sort);
        students.stream().map(s -> s.getName()).collect(Collectors.toList()).forEach(s -> System.out.println(s));
//        System.out.println(ss);
        return ResponseEntity.ok().body(/*companyRepository.findCompanyByComStrengthGreaterThanEqualOrderByComIdDesc(250)*/null);
    }

}
