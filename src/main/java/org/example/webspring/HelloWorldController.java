package org.example.webspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
        // http://localhost:8080/api/hello
    }

    // Hier wird die Pfadvariable {name} verwendet
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hallo, " + name + "!";
    }
    //http://localhost:8080/api/hello/Jon
}
