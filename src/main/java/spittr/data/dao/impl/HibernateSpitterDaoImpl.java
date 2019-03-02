package spittr.data.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spittr.common.SpitterProfiles;
import spittr.data.dao.SpitterDao;
import spittr.data.models.Spitter;
import spittr.data.models.entities.HibernateSpitter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
@Profile(SpitterProfiles.HIBERNATE)
@Transactional
public class HibernateSpitterDaoImpl
        implements SpitterDao {

    private final Logger log = LogManager.getLogger(this.getClass());
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Spitter create(Spitter spitter) {
        log.debug("#### SPITTERDAO CREATE ####");
        log.debug("got spitter {}", spitter);
        HibernateSpitter hibernateSpitter = modelMapper.map(spitter, HibernateSpitter.class);
        log.debug("Spitter is converted to hibSpitter {}", hibernateSpitter);

        entityManager.persist(hibernateSpitter);

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

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<HibernateSpitter> criteriaQuery = builder.createQuery(HibernateSpitter.class);
        Root<HibernateSpitter> c = criteriaQuery.from(HibernateSpitter.class);
        criteriaQuery
                .select(c)
                .where(builder.equal(c.get("username"), username));
        HibernateSpitter singleResult = entityManager.createQuery(criteriaQuery).getSingleResult();

        Spitter spitterFound = modelMapper.map(singleResult, Spitter.class);
        return spitterFound;
    }

    @Override
    public Spitter findById(Long id) {
        log.debug("#### SPITTERDAO FINDBYID ####");
        log.debug("getting hib spitter by id {}", id);

        HibernateSpitter hibSpitter = entityManager.find(HibernateSpitter.class, id);
        log.debug("got HibernateSpitter {}", hibSpitter);

        Spitter spitterFound = modelMapper.map(hibSpitter, Spitter.class);
        log.debug("hibSpitter is converted to spitter {}", spitterFound);
        return spitterFound;
    }
}
