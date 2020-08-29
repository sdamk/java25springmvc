package pl.sda.springmvc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.springmvc.dto.LoginDTO;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping
    ModelAndView loginPage() {
        ModelAndView mnv = new ModelAndView("login");
        mnv.addObject("login", new LoginDTO());
        return mnv;
    }
}
