package chapt02prj01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {

    @GetMapping("/video/{country}/{language}")
    public String video(@PathVariable("country") String country,
                        @PathVariable("language") String language) {
        return "Video from " + country + " language " + language;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
