package spittr.data.dao.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import spittr.common.SpitterProfiles;
import spittr.data.dao.SpitterDao;
import spittr.data.models.Spitter;
import spittr.exeptions.DuplicateSpittleException;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile(SpitterProfiles.NOT_HIBERNATE)
public class InMemorySpitterDaoImpl implements SpitterDao {

    private List<Spitter> spitters = new ArrayList<>();

    @Override
    public Spitter create(Spitter spitter) {
        if (findOneByUsername(spitter.getUsername()) != null){
            throw new DuplicateSpittleException();
        }
        spitter.setId((long) spitters.size());
        spitters.add(spitter);
        return spitter;
    }

    @Override
    public boolean delete(Spitter spitter) {
        return false;
    }

    @Override
    public int update(Spitter spitter) {
        return 0;
    }

    @Override
    public Spitter findOneByUsername(String username) {
        Spitter spitterByName = null;
        try {
            spitterByName = spitters.stream()
                    .filter(spitter -> spitter.getUsername().equals(username))
                    .findFirst().get();
        } catch (Exception e){
            System.out.println("There is an exception " + e.getMessage());
        }

        return spitterByName;
    }

    @Override
    public Spitter findById(Long id) {
        return null;
    }
}
