package spittr.services;

import spittr.data.models.Spitter;
import spittr.data.models.Spittle;

public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}