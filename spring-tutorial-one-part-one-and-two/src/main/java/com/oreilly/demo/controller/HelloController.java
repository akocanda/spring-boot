package com.oreilly.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// The dispatcher scans the classes annotated with @Controller and detects @RequestMapping annotations within them.
// (@Indexed) Dispatcher Servlet maintains / delegates requests

//BootRun combines building the application + booting the jar
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(
            @RequestParam(value = "name", required = false,
                    defaultValue = "World") String name, Model model) {
        model.addAttribute("user", name);
        return "hello";
    }
}
