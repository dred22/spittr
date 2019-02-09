package spittr.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import spittr.data.dao.SpitterDao;
import spittr.data.models.Spitter;
import spittr.exeptions.DuplicateSpittleException;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("hibernate")
public class HibernateSpitterDaoImpl
        implements SpitterDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Spitter create(Spitter obj) {
        return null;
    }

    @Override
    public boolean delete(Spitter obj) {
        return false;
    }

    @Override
    public int update(Spitter obj) {
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
