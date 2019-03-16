package spittr.data.dao.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.common.SpitterProfiles;
import spittr.config.RootConfig;
import spittr.data.dao.SpitterDao;
import spittr.data.models.Reference;

import javax.transaction.Transactional;
import java.time.LocalDate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@ActiveProfiles(SpitterProfiles.HIBERNATE)
@Transactional
@TestPropertySource(locations = "classpath:test.properties")
public class HibernateSpitterDaoImplTest {

    @Autowired
    private SpitterDao spitterDao;

    @Test
    public void create_and_find_by_id() {
        Reference spitter = new Reference("Dres", LocalDate.now());
        Reference spitterSaved = spitterDao.create(spitter);
        Assert.assertNotNull(spitterSaved);
        Long savedId = spitterSaved.getId();
        Assert.assertNotNull(savedId);

        Reference spitterDres = spitterDao.findById(savedId);
        Assert.assertNotNull(spitterDres);
        Assert.assertNotNull(spitterDres.getId());
    }

}