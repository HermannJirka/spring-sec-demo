package chapt02prj01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/a")
    public String endpointA(){
        return "WORKS!";
    }

    @GetMapping("/b")
    public String endpointB(){
        return "WORKS!";
    }
    @GetMapping("/a/b")
    public String endpointAB(){
        return "WORKS!";
    }

    @GetMapping("/a/b/c")
    public String endpointABC(){
        return "WORKS!";
    }

    @PostMapping("/a")
    public String endpointAPost(){
        return "WORKS!";
    }
}
