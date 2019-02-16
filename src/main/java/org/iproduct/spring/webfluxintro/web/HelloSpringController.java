package org.iproduct.spring.webfluxintro.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value="name", defaultValue="Anonimous" ) String name) {
        return "Hello " + name + " from Spring!!!";
    }
}
