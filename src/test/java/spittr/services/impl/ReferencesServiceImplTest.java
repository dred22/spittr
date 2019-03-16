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
import spittr.data.models.Reference;
import spittr.services.ReferencesService;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@ActiveProfiles(SpitterProfiles.HIBERNATE)
@TestPropertySource(locations = "classpath:test.properties")
public class ReferencesServiceImplTest {

    @Autowired
    private ReferencesService repository;

    @Test
    public void findByUsername() {
        Reference reference = repository.findByUsername("test1");
        assertNotNull(reference);
        assertEquals("pass1", reference.getPassword());
    }

    @Test
    @Transactional
    public void create_and_find_by_id() {
        Reference spitter = new Reference("Dres", LocalDate.now());
        Reference spitterSaved = repository.save(spitter);
        Assert.assertNotNull(spitterSaved);
        Long savedId = spitterSaved.getId();
        Assert.assertNotNull(savedId);

        Reference spitterDres = repository.findByUsername("Dres");
        Assert.assertNotNull(spitterDres);
        Assert.assertNotNull(spitterDres.getId());
    }
}