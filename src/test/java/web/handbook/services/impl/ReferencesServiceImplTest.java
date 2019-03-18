package web.handbook.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import web.handbook.common.HandbookProfiles;
import web.handbook.config.RootConfig;
import web.handbook.data.models.Reference;
import web.handbook.services.ReferencesService;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@ActiveProfiles(HandbookProfiles.HIBERNATE)
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
        Reference reference = new Reference("Dres", LocalDate.now());
        Reference referenceSaved = repository.save(reference);
        Assert.assertNotNull(referenceSaved);
        Long savedId = referenceSaved.getId();
        Assert.assertNotNull(savedId);

        Reference referenceDres = repository.findByUsername("Dres");
        Assert.assertNotNull(referenceDres);
        Assert.assertNotNull(referenceDres.getId());
    }
}