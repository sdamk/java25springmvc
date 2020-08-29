package pl.sda.springmvc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.springmvc.dto.NewUserDTO;
import pl.sda.springmvc.springmvc.exception.UserLoginExistException;
import pl.sda.springmvc.springmvc.service.UserService;
import pl.sda.springmvc.springmvc.validator.NewUserValidator;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;
    private final NewUserValidator validator;

    //@Autowired
    public RegistrationController(UserService userService,
                                  NewUserValidator validator) {
        this.userService = userService;
        this.validator = validator;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @GetMapping
    ModelAndView registrationPage() {
        ModelAndView mnv = new ModelAndView("registration/registration");
        mnv.addObject("registration", new NewUserDTO());
        return mnv;
    }

    @PostMapping
    ModelAndView createNewUser(@ModelAttribute("registration") @Validated NewUserDTO newUserDTO,
                               BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ModelAndView("registration/registration");
        }

        try{
            userService.createUser(newUserDTO);
        }catch (UserLoginExistException e) {
            ModelAndView mnv = new ModelAndView("registration/registration");
            mnv.addObject("error", e.getMessage());
            return mnv;
        }
        return new ModelAndView("redirect:/login");
    }
}
