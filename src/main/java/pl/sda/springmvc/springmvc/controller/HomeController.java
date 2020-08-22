package pl.sda.springmvc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
class HomeController {

    @RequestMapping
    ModelAndView indexPage() {
        ModelAndView mnv = new ModelAndView("index");
        String name = "Michal";
        mnv.addObject("name", name);
        return mnv;
    }

}
