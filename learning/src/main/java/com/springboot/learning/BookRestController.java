package com.springboot.learning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {

    @GetMapping("/test")
    public String helloWord(){
        return "Yo bro";
    }
}
