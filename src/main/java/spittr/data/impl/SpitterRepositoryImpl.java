package spittr.data.impl;

import org.springframework.stereotype.Repository;
import spittr.data.models.Spitter;
import spittr.data.models.Spittle;
import spittr.data.SpitterRepository;

@Repository
public class SpitterRepositoryImpl implements SpitterRepository {

    @Override
    public Spitter save(Spitter spitter) {
        return spitter;
    }
}
