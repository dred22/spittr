package spittr.data.dao.impl;

import org.springframework.stereotype.Repository;
import spittr.data.dao.SpitterDao;
import spittr.data.models.Spitter;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemorySpitterDaoImpl implements SpitterDao {

    private List<Spitter> spitters = new ArrayList<>();

    @Override
    public Spitter create(Spitter obj) {
        obj.setId((long) spitters.size());
        spitters.add(obj);
        return obj;
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
        Spitter spitterByName = spitters.stream()
                .filter(spitter -> spitter.getUsername().equals(username))
                .findFirst().get();
        return spitterByName;
    }

    @Override
    public Spitter findById(Long id) {
        return null;
    }
}
