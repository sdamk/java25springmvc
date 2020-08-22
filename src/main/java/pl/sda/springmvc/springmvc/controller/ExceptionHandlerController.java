package pl.sda.springmvc.springmvc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.springmvc.exception.ProductNotFoundException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ProductNotFoundException.class)
    ModelAndView productNotFoundPage(ProductNotFoundException e) {
        ModelAndView mnv = new ModelAndView("error");
        mnv.addObject("message", e.getMessage());
        return mnv;
    }
}
