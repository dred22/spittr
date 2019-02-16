package spittr.data.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import spittr.common.SpitterProfiles;
import spittr.data.dao.SpitterDao;
import spittr.data.models.Spitter;
import spittr.data.models.entities.HibernateSpitter;

import javax.transaction.Transactional;

@Repository
@Profile(SpitterProfiles.HIBERNATE)
@Transactional
public class HibernateSpitterDaoImpl
        implements SpitterDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ModelMapper modelMapper;

    private final Logger log = LogManager.getLogger(this.getClass());

    @Override
    public Spitter create(Spitter spitter) {
        log.debug("#### SPITTERDAO CREATE ####");
        log.debug("got spitter {}", spitter);
        HibernateSpitter hibernateSpitter = modelMapper.map(spitter, HibernateSpitter.class);
        log.debug("Spitter is converted to hibSpitter {}", hibernateSpitter);

        sessionFactory.getCurrentSession().save(hibernateSpitter);
        log.debug("hibSpitter is saved {}", hibernateSpitter);
        Spitter spitterSaved = modelMapper.map(hibernateSpitter, Spitter.class);
        log.debug("hibSpitter is converted to spitter {}", spitterSaved);
        return spitterSaved;
    }

    @Override
    public boolean delete(Spitter spitter) {
        return false;
    }

    @Override
    public int update(Spitter spitter) {
        return 0;
    }

    @Override
    public Spitter findOneByUsername(String username) {
        return null;
    }

    @Override
    public Spitter findById(Long id) {
        return null;
    }
}
