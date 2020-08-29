package pl.sda.springmvc.springmvc.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.sda.springmvc.springmvc.dto.NewUserDTO;


@Component
public class NewUserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return NewUserDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NewUserDTO newUserDTO = (NewUserDTO) o;
        if(StringUtils.isBlank(newUserDTO.getLogin())) {
            errors.rejectValue("login", "validator.field.blank");
        }
    }
}
