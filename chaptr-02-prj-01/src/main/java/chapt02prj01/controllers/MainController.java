package chapt02prj01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @PostMapping("/main")
    public String postHello() {
        return "Post hello";
    }

    @PostMapping("/ciao")
    public String postCiao() {
        return "Post ciao";
    }
}
