package spittr.data.dao.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.common.SpitterProfiles;
import spittr.config.RootConfig;
import spittr.data.dao.SpitterDao;
import spittr.data.models.Spitter;

import javax.transaction.Transactional;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@ActiveProfiles(SpitterProfiles.HIBERNATE)
@Transactional
public class HibernateSpitterDaoImplTest {

    @Autowired
    private SpitterDao spitterDao;

    @Test
    public void findOneByUsername() {
        Spitter test = spitterDao.findOneByUsername("test");
        System.out.println(test);

    }
    @Test
    public void create() {
        Spitter spitter = new Spitter("Dres", new Date());
        Spitter spitterSaved = spitterDao.create(spitter);
        Assert.assertNotNull(spitterSaved);
        Assert.assertNotNull(spitterSaved.getId());
        //System.out.println(spitterDao.create(spitter));

    }

}