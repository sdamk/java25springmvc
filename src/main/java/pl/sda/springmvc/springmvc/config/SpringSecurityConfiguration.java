package pl.sda.springmvc.springmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String[] ADMIN_MATCHERS = {"/admin*" , "/admin/*", "/admin/**"};
    private static final String[] LOGGED_USER_MATCHER = {"/profile", "/cart"};

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers(ADMIN_MATCHERS)
                .hasRole("ADMIN")
                .antMatchers(LOGGED_USER_MATCHER)
                .authenticated()
                .anyRequest()
                .permitAll();
    }
}
