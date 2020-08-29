package pl.sda.springmvc.springmvc.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.springmvc.springmvc.entity.User;
import pl.sda.springmvc.springmvc.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = repository
                .findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException(login));

        //hack - FIX ME!!!!
        List<GrantedAuthority> roles = login.equals("admin") ?
                mapToRole("ADMIN") : mapToRole("USER");

        return new
                org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPassword(),
                roles);
    }

    private List<GrantedAuthority> mapToRole(String... roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
        return authorities;
    }
}
