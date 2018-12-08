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

    @Override
    public Spitter findByUsername(String username) {
        return new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
    }
}
