package com.example.springwebannoted;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class ComController2 {

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
        Company company = restTemplate.getForObject("http://localhost:8080/SpringWeb_war_exploded/response/getCom",Company.class);
        return ResponseEntity.ok().body("Okay."+company.toString());
    }

    @PostMapping("/v5/rest")
    public ResponseEntity<String> postRest() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON,MediaType.APPLICATION_FORM_URLENCODED));
        Company cmo = new Company("","dfgdfgb",100.2,50000);
        HttpEntity<Company> comEntity = new HttpEntity<>(cmo);
//        /*ResponseEntity<Company> response = */restTemplate.exchange("http://localhost:8080/SpringWeb_war_exploded/response/addCom", HttpMethod.POST,comEntity,Company.class);
//        String company = String.valueOf(response.getBody());
//        Company str = restTemplate.postForObject(new URI("http://localhost:8080/SpringWeb_war_exploded/response/addCom"),cmo,Company.class);
        ResponseEntity<Company> response = restTemplate.exchange(new URI("http://localhost:8080/SpringWeb_war_exploded/response/addCom"),HttpMethod.POST,comEntity,Company.class);
        Company str = response.getBody();
        return ResponseEntity.ok().body("Okay."/*+company*/+str);
    }


    @GetMapping("/v6/rest")
    public ResponseEntity<String> testv6() {
        UriComponents components = UriComponentsBuilder.fromUriString("http://localhost:8080/SpringWeb_war_exploded/response/getCom").queryParam("weree","1234").build();
//        URI uri = components.expand("rgsg","123").toUri();
        URI uri = UriComponentsBuilder
                .fromUriString("https://example.com/hotels/{hotel}")
                .queryParam("q", "{q}")
                .encode()
                .buildAndExpand("Westin", "123")
                .toUri();
        return ResponseEntity.ok().body("Okay.\n"+components+"\n"+uri);
    }
}
