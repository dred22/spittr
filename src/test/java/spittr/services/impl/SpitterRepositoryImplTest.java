package spittr.services.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.config.RootConfig;
import spittr.data.models.Spitter;
import spittr.services.SpitterRepository;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class SpitterRepositoryImplTest {

    @Autowired
    SpitterRepository repository;

    @Test
    public void findByUsername_default_users() {
        Spitter spitterAdmin = repository.findByUsername("admin");
        assertNotNull(spitterAdmin);
        assertEquals("adminpass", spitterAdmin.getPassword());
    }
}