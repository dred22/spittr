package spittr.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spittr.data.dao.ReferenceDao;
import spittr.data.models.Reference;
import spittr.services.ReferencesService;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ReferencesServiceImpl
        implements ReferencesService {

    @Autowired
    private ReferenceDao referenceDao;

    private Map<String, String> mapUserAndPassword;

    @Override
    public Reference save(Reference reference) {
        return referenceDao.create(reference);
    }

    @Override
    public Reference findByUsername(String reference) {
        Reference oneByName = referenceDao.findOneByUsername(reference);
        return oneByName;
    }

    @Override
    public List<Reference> findReferences(long max, int count) {
        //return Arrays.asList(new Reference("Maga", LocalDate.now()), new Reference("Istre", LocalDate.now()));
        return referenceDao.findAll();
    }

    @Override
    public Reference findOne(long i) {


        return null;
    }
}
