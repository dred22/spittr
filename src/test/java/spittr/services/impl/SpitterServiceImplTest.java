package spittr.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import spittr.common.SpitterProfiles;
import spittr.config.RootConfig;
import spittr.data.models.Spitter;
import spittr.services.SpitterService;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@ActiveProfiles(SpitterProfiles.HIBERNATE)
@TestPropertySource(locations = "classpath:test.properties")
public class SpitterServiceImplTest {

    @Autowired
    private SpitterService repository;

    @Test
    public void findByUsername_default_users() {
        Spitter spitterAdmin = repository.findByUsername("admin");
        assertNotNull(spitterAdmin);
        assertEquals("admin", spitterAdmin.getPassword());
    }

    @Test
    public void findByUsername() {
        Spitter spitterAdmin = repository.findByUsername("test1");
        assertNotNull(spitterAdmin);
        assertEquals("pass", spitterAdmin.getPassword());
    }

    @Test
    @Transactional
    public void create_and_find_by_id() {
        Spitter spitter = new Spitter("Dres", LocalDate.now());
        Spitter spitterSaved = repository.save(spitter);
        Assert.assertNotNull(spitterSaved);
        Long savedId = spitterSaved.getId();
        Assert.assertNotNull(savedId);

        Spitter spitterDres = repository.findByUsername("Dres");
        Assert.assertNotNull(spitterDres);
        Assert.assertNotNull(spitterDres.getId());
    }
}