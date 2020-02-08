package web.handbook.data.dao;

import org.springframework.data.repository.CrudRepository;
import web.handbook.data.models.entities.HibernateReference;

public interface ReferenceDao
        extends CrudRepository<HibernateReference, Long> {
    HibernateReference findOneByUserName(String userName);
}
