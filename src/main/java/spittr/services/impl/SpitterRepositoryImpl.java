package spittr.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spittr.data.dao.SpitterDao;
import spittr.data.models.Spitter;
import spittr.services.SpitterRepository;

@Repository
public class SpitterRepositoryImpl implements SpitterRepository {

    @Autowired
    private SpitterDao spitterDao;

    @Override
    public Spitter save(Spitter spitter) {
        return spitterDao.create(spitter);
    }

    @Override
    public Spitter findByUsername(String username) {
        Spitter oneByName = spitterDao.findOneByUsername(username);
        return oneByName;
    }
}