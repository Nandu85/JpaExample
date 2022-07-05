package com.example.springweb;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/response")
public class ComController {

    @GetMapping(name = "Test API", value = "/hello")
    public ResponseEntity<String> testHello(){
        return ResponseEntity.ok("Hello");
    }


    @PostMapping("/addCom")
    public ResponseEntity<String> create(Company company){
        System.out.println(company.toString());
        return ResponseEntity.ok("Com Added "+company.getComName());
    }

    @PostMapping(value = "/addCom",headers = "KeyVal")
    public ResponseEntity<String> createWithHeader(Company company, HttpServletRequest req){
        System.out.println(company.toString());
        return ResponseEntity.ok("Com Added "+company.getComName()+" Header "+req.getHeader("KeyVal"));
    }
}
