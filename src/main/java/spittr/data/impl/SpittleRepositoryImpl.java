package spittr.data.impl;

import org.springframework.stereotype.Repository;
import spittr.data.models.Spittle;
import spittr.data.SpittleRepository;

import java.util.List;

@Repository
public class SpittleRepositoryImpl implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }

    @Override
    public Spittle findOne(long i) {
        return null;
    }
}
