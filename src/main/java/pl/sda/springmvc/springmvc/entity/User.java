package pl.sda.springmvc.springmvc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String login;
    private String password;
    private LocalDateTime registrationDate = LocalDateTime.now();

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
