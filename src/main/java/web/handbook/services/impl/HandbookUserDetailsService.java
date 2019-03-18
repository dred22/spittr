package web.handbook.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.handbook.data.dao.UserDao;
import web.handbook.data.models.entities.HibernateUser;

import java.util.Arrays;

@Service
public class HandbookUserDetailsService
        implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        HibernateUser hibernateUser = userDao.findOneByUsername(userName);
        GrantedAuthority authority = new SimpleGrantedAuthority(hibernateUser.getAuthority());
        UserDetails userDetails = new User(hibernateUser.getUsername(),
                                           hibernateUser.getPassword(), Arrays.asList(authority));
        return userDetails;
    }
}
