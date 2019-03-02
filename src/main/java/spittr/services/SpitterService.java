package spittr.services;

import spittr.data.models.Spitter;

import java.util.List;

public interface SpitterService {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);

    List<Spitter> findSpitters(long max, int count);

    Spitter findOne(long i);
}