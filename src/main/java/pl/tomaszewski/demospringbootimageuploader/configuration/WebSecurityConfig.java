package pl.tomaszewski.demospringbootimageuploader.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.tomaszewski.demospringbootimageuploader.model.User;
import pl.tomaszewski.demospringbootimageuploader.repository.UserRepo;
import pl.tomaszewski.demospringbootimageuploader.service.UserDetailsServiceImpl;

import java.util.Collections;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsServiceImpl userDetailsService;
    private UserRepo userRepo;

    @Autowired
    public WebSecurityConfig (UserDetailsServiceImpl userDetailsService, UserRepo userRepo){
        this.userDetailsService = userDetailsService;
        this.userRepo = userRepo;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/test1").hasRole("USER")
                .antMatchers("/test2").hasRole("ADMIN")
                .antMatchers("/uploadImage").hasRole("ADMIN")
        .and()
        .formLogin().permitAll()
        .and()
        .csrf().disable().headers().disable();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void addUserToDb(){
        User user = new User("user",passwordEncoder().encode("user").toCharArray(),"ROLE_USER");
        User admin = new User("admin",passwordEncoder().encode("admin").toCharArray(),"ROLE_ADMIN");
        userRepo.save(user);
        userRepo.save(admin);
    }
}
