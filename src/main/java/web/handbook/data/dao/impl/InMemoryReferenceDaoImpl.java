package web.handbook.data.dao.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import web.handbook.common.HandbookProfiles;
import web.handbook.data.dao.ReferenceDao;
import web.handbook.data.models.Reference;
import web.handbook.exeptions.DuplicateReferenceException;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile(HandbookProfiles.IN_MEMORY)
public class InMemoryReferenceDaoImpl
        implements ReferenceDao {

    private List<Reference> references = new ArrayList<>();

    @Override
    public Reference create(Reference reference) {
        if (findOneByUsername(reference.getUsername()) != null) {
            throw new DuplicateReferenceException();
        }
        reference.setId((long) references.size());
        references.add(reference);
        return reference;
    }

    @Override
    public boolean delete(Reference reference) {
        return false;
    }

    @Override
    public int update(Reference reference) {
        return 0;
    }

    @Override
    public Reference findOneByUsername(String username) {
        Reference referenceByName = null;
        try {
            referenceByName = references.stream()
                    .filter(reference -> reference.getUsername().equals(username))
                    .findFirst().get();
        }
        catch (Exception e) {
            System.out.println("There is an exception " + e.getMessage());
        }

        return referenceByName;
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
