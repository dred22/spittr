package spittr.data.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.common.SpitterProfiles;
import spittr.config.RootConfig;
import spittr.data.dao.SpitterDao;
import spittr.data.models.Spitter;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@ActiveProfiles(SpitterProfiles.HIBERNATE)
public class HibernateSpitterDaoImplTest {

    @Autowired
    private SpitterDao spitterDao;

    @Test
    public void findOneByUsername() {
        Spitter test = spitterDao.findOneByUsername("test");
        System.out.println(test);

    }

}