package chapt02prj01.controllers;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/ciao")
    public String ciao() {
        return "Ciao";
    }

    @GetMapping("/guten")
    public String gutenTag() {
        return "Gutentag";
    }

    @GetMapping("/hola")
    public String hola(){
        SecurityContext context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();
        return "Hola "+name;
    }
}
