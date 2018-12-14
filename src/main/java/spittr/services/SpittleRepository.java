package spittr.services;

import java.util.List;

import spittr.data.models.Spittle;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long i);

}