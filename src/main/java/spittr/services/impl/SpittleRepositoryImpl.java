package spittr.services.impl;

import org.springframework.stereotype.Repository;
import spittr.data.models.Spittle;
import spittr.services.SpittleRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
public class SpittleRepositoryImpl implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return Arrays.asList(new Spittle("Maga", new Date()), new Spittle("Istre", new Date()));
    }

    @Override
    public Spittle findOne(long i) {


        return null;
    }
}
