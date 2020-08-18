package chapt02prj01.controllers;

import chapt02prj01.service.ProductService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private final ProductService productService;

    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/main")
    public String main(Authentication a, Model model){
        model.addAttribute("username",a.getName());
        model.addAttribute("products",productService.getAllProducts());
        return "main.html";
    }

}
