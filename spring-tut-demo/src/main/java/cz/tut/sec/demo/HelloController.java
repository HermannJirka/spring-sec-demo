package cz.tut.sec.demo;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class HelloController {
    @GetMapping("/home")
    public String home() {
        return "home.html";
    }
}