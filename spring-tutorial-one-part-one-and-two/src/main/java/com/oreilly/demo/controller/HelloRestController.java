package com.oreilly.demo.controller;

import com.oreilly.demo.domain.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//RestController automatically adds in JSON deserializaiton for requestMappings
@RestController
public class HelloRestController {
    @GetMapping("/rest")
    public Greeting greet(
            @RequestParam(required = false, defaultValue = "World") String name
    ) {
        return new Greeting(String.format("Hello, %s !", name));
    }
}
