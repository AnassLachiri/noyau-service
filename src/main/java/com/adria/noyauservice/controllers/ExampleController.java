package com.adria.noyauservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/example")
public class ExampleController {

    @GetMapping
    public String sayHello(){
        return "Hello world";
    }
}
