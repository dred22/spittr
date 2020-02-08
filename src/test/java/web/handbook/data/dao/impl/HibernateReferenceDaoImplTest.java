package web.handbook.data.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import web.handbook.common.HandbookProfiles;
import web.handbook.data.dao.ReferenceDao;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)

@ActiveProfiles(HandbookProfiles.HIBERNATE)
@Transactional
@TestPropertySource(locations = "classpath:test.properties")
public class HibernateReferenceDaoImplTest {

    @Autowired
    private ReferenceDao referenceDao;

    @Test
    public void create_and_find_by_id() {
/*        Reference reference = new Reference("Dres", LocalDate.now());
        Reference referenceSaved = referenceDao.create(reference);
        Assert.assertNotNull(referenceSaved);
        Long savedId = referenceSaved.getId();
        Assert.assertNotNull(savedId);

        Reference referenceDres = referenceDao.findById(savedId);
        Assert.assertNotNull(referenceDres);
        Assert.assertNotNull(referenceDres.getId());*/
    }

}