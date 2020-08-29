package pl.sda.springmvc.springmvc.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

//Command
@Data
@EqualsAndHashCode
public class NewUserDTO {
    private String login;
    private String password;
    private String repeatedPassword;
}
