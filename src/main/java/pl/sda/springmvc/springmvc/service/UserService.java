package pl.sda.springmvc.springmvc.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.springmvc.springmvc.dto.NewUserDTO;
import pl.sda.springmvc.springmvc.entity.User;
import pl.sda.springmvc.springmvc.exception.UserLoginExistException;
import pl.sda.springmvc.springmvc.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(NewUserDTO newUserDTO) {
        if(userRepository.existsByLogin(newUserDTO.getLogin())) {
            throw new UserLoginExistException(newUserDTO.getLogin());
        }
        User user = new User(newUserDTO.getLogin(),
                passwordEncoder.encode(newUserDTO.getPassword()));
        userRepository.save(user);
    }
}
