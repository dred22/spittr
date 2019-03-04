package spittr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import javax.sql.DataSource;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig
        extends WebSecurityConfigurerAdapter {

/*    @Autowired
    private SpitterService spitterRepository;*/

    @Autowired
    DataSource dataSource;

    /* in memory authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService((username) -> {
            Spitter spitter = spitterRepository.findByUsername(username);
            if (spitter != null) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));

                return new User(
                        spitter.getUsername(),
                        spitter.getPassword(),
                        authorities);
            }
            throw new UsernameNotFoundException("User '" + username + "' not found.");
        });
    }*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http)
            throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/spitters").permitAll()
                .anyRequest().authenticated()
                .and().formLogin();
    }
}