
package com.example.plan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author admin
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("titulo", "Bienvenido a Thymeleaf");
        return "index";
    }
}
