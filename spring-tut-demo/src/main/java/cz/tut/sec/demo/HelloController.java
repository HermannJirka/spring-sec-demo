package cz.tut.sec.demo;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class HelloController {
    @GetMapping("/hello")
    public String hello(Authentication authentication) {
        return "Hello: " + authentication.getName();
    }

    @GetMapping("/ciao")
    public String ciao(Authentication authentication) {
        return "Ciao!: " + authentication.getName();
    }

    @GetMapping("/a")
    public String getA(){
        return "works";
    }
    @PostMapping("/a")
    public String postA(){
        return "works";
    }

    @GetMapping("/a/b")
    public String getAB(){
        return "works";
    }

    @GetMapping("/a/b/c")
    public String getABC(){
        return "works";
    }

}
