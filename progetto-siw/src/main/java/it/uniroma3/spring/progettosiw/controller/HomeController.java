package it.uniroma3.spring.progettosiw.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;

@Controller
public class HomeController {
    
	private String appMode;

    @Autowired
    public HomeController(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("username", "@SilphSPA");
        model.addAttribute("projectname", "Home");

        model.addAttribute("mode", appMode);

        return "index";
    }
}

