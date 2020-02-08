/*
package web.handbook.data.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.handbook.common.HandbookProfiles;
import web.handbook.data.dao.ReferenceDao;
import web.handbook.data.models.Reference;
import web.handbook.data.models.entities.HibernateReference;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Profile(HandbookProfiles.HIBERNATE)
@Transactional
public class HibernateReferenceDaoImpl
        implements ReferenceDao {

    private final Logger log = LogManager.getLogger(this.getClass());
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Reference create(Reference reference) {
        log.debug("#### referenceDAO CREATE ####");
        log.debug("got reference {}", reference);
        HibernateReference hibernateReference = modelMapper.map(reference, HibernateReference.class);
        log.debug("Reference is converted to hibreference {}", hibernateReference);

        entityManager.persist(hibernateReference);

        log.debug("hibreference is saved {}", hibernateReference);
        Reference referenceSaved = modelMapper.map(hibernateReference, Reference.class);
        log.debug("hibreference is converted to reference {}", referenceSaved);
        return referenceSaved;
    }

    @Override
    public boolean delete(Reference reference) {
        return false;
    }

    @Override
    public int update(Reference reference) {
        return 0;
    }

    @Override
    public Reference findOneByUsername(String username) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<HibernateReference> criteriaQuery = builder.createQuery(HibernateReference.class);
        Root<HibernateReference> c = criteriaQuery.from(HibernateReference.class);
        criteriaQuery
                .select(c)
                .where(builder.equal(c.get("username"), username));
        HibernateReference singleResult = entityManager.createQuery(criteriaQuery).getSingleResult();

        Reference referenceFound = modelMapper.map(singleResult, Reference.class);
        return referenceFound;
    }

    @Override
    public Reference findById(Long id) {
        log.debug("#### referenceDAO FINDBYID ####");
        log.debug("getting hib reference by id {}", id);

        HibernateReference hibernateReference = entityManager.find(HibernateReference.class, id);
        log.debug("got HibernateReference {}", hibernateReference);

        Reference referenceFound = modelMapper.map(hibernateReference, Reference.class);
        log.debug("hibernateReference is converted to reference {}", referenceFound);
        return referenceFound;
    }

    @Override
    public List<Reference> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<HibernateReference> criteriaQuery = builder.createQuery(HibernateReference.class);
        Root<HibernateReference> c = criteriaQuery.from(HibernateReference.class);
        criteriaQuery.select(c);
        List<HibernateReference> resultList = entityManager.createQuery(criteriaQuery).getResultList();
        return resultList.stream()
                .map(s -> modelMapper.map(s, Reference.class))
                .collect(Collectors.toList());
    }
}
*/
