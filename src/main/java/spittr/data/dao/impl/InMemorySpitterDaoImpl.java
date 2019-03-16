package spittr.data.dao.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import spittr.common.SpitterProfiles;
import spittr.data.dao.SpitterDao;
import spittr.data.models.Reference;
import spittr.exeptions.DuplicateReferenceException;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile(SpitterProfiles.IN_MEMORY)
public class InMemorySpitterDaoImpl
        implements SpitterDao {

    private List<Reference> spitters = new ArrayList<>();

    @Override
    public Reference create(Reference spitter) {
        if (findOneByUsername(spitter.getUsername()) != null) {
            throw new DuplicateReferenceException();
        }
        spitter.setId((long) spitters.size());
        spitters.add(spitter);
        return spitter;
    }

    @Override
    public boolean delete(Reference spitter) {
        return false;
    }

    @Override
    public int update(Reference spitter) {
        return 0;
    }

    @Override
    public Reference findOneByUsername(String username) {
        Reference spitterByName = null;
        try {
            spitterByName = spitters.stream()
                    .filter(spitter -> spitter.getUsername().equals(username))
                    .findFirst().get();
        }
        catch (Exception e) {
            System.out.println("There is an exception " + e.getMessage());
        }

        return spitterByName;
    }

    @Override
    public Reference findById(Long id) {
        return null;
    }

    @Override
    public List<Reference> findAll() {
        return null;
    }
}
