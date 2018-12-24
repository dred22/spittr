package spittr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import spittr.data.models.Spitter;
import spittr.services.SpitterRepository;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig
        extends WebSecurityConfigurerAdapter {

    @Autowired
    private SpitterRepository spitterRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .userDetailsService((username) -> {
                    Spitter spitter = spitterRepository.findByUsername(username);
                    if (spitter != null) {
                        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                        authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));

                        return new User(
                                spitter.getUsername(),
                                spitter.getPassword(),
                                authorities);
                    }
                    throw new UsernameNotFoundException("User '" + username + "' not found.");
                });
    }

    @Override
    protected void configure(HttpSecurity http)
            throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and().formLogin();
    }
}