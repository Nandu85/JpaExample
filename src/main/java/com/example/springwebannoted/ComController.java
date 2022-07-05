package com.example.springwebannoted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/response")
public class ComController {

    @Autowired
    private Validator comValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(comValidator);
    }

    @GetMapping(name = "Test API", value = "/hello")
    public ResponseEntity<String> testHello() {
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("/company/{comId}")
    public ResponseEntity<String> getCom(@PathVariable int comId, @RequestParam("var") int var) {
        return ResponseEntity.ok("Hello " + comId + " " + var);
    }

//    @GetMapping("/company/{comId}")
//    public void getComWithMatrix(@PathVariable int comId, @MatrixVariable(pathVar = "comId") int var){
//        System.out.println("Hello"+comId+" "+var);
//    }

    @PostMapping(value = "/addCom")
    public ResponseEntity<Company> create(@Validated @RequestBody Company company, BindingResult bindingResult) {
        System.out.println(company.toString());
        System.out.println(bindingResult.getAllErrors().toString());
        return ResponseEntity.ok(company);
    }

    @PostMapping(value = "/addCom", headers = "KeyVal")
    public ResponseEntity<String> createWithHeader(@Validated @RequestBody Company company, HttpServletRequest req) {
        System.out.println(company.toString());
        return ResponseEntity.ok("Com Added " + company.getComName() + " Header " + req.getHeader("KeyVal"));
    }

    @PostMapping("/comform")
    public ModelAndView addCom1(Company company) {
        ModelAndView modelAndView;
        if (company.getComName().length() > 5) modelAndView = new ModelAndView("comView");
        else modelAndView = new ModelAndView("redirect:newjsp");
        modelAndView.addObject(company);
        return modelAndView;
    }

    @GetMapping("/comform")
    public ModelAndView viewCom1() {
        ModelAndView modelAndView = new ModelAndView("comView");
//        modelAndView.addObject(company);
        return modelAndView;
    }

//    @ModelAttribute
//    public void modelAttribute1(Model model) {
//        model.addAttribute("msg", "Welcome to Spring");
//    }

    @GetMapping("/newjsp")
    public String viewjsp(Model model) throws Exception {
        model.addAttribute("msg1", "Hey It's time to fun");
        throw new CustomException("Exception of the day.");
//        String msg = (String) model.getAttribute("msg");
//        return "NewJSp";
    }

    @GetMapping("getCom")
    @ResponseBody
    public Company getCom() {
        Company company = new Company();
        company.setComId(2);
        company.setComName("fgdfggf");
        company.setComOwner("narola");
        company.setComStrength(378);
        return company;
    }

//    @ExceptionHandler
//    @ResponseBody
//    public ResponseEntity<ErrorObj> handle(Exception e){
//        return ResponseEntity.badRequest().body(new ErrorObj(HttpStatus.BAD_REQUEST.value() , e.getMessage()));
//    }



}
