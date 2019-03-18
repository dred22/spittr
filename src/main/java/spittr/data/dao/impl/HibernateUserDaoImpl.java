package spittr.data.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import spittr.data.dao.UserDao;
import spittr.data.models.entities.HibernateUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HibernateUserDaoImpl
        implements UserDao {

    private final Logger log = LogManager.getLogger(this.getClass());

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public HibernateUser create(HibernateUser reference) {
        return null;
    }

    @Override
    public boolean delete(HibernateUser reference) {
        return false;
    }

    @Override
    public int update(HibernateUser reference) {
        return 0;
    }

    @Override
    public HibernateUser findOneByUsername(String username) {

        HibernateUser hibernateUser = entityManager.find(HibernateUser.class, username);

        return hibernateUser;
    }

    @Override
    public HibernateUser findById(Long id) {
        return null;
    }

    @Override
    public List<HibernateUser> findAll() {
        return null;
    }
}
