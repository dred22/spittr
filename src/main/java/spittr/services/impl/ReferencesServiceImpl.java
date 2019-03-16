package spittr.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spittr.data.dao.SpitterDao;
import spittr.data.models.Reference;
import spittr.services.ReferencesService;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ReferencesServiceImpl
        implements ReferencesService {

    @Autowired
    private SpitterDao spitterDao;

    private Map<String, String> mapUserAndPassword;

    @Override
    public Reference save(Reference reference) {
        return spitterDao.create(reference);
    }

    @Override
    public Reference findByUsername(String reference) {
        Reference oneByName = spitterDao.findOneByUsername(reference);
        return oneByName;
    }

    @Override
    public List<Reference> findReferences(long max, int count) {
        //return Arrays.asList(new Reference("Maga", LocalDate.now()), new Reference("Istre", LocalDate.now()));
        return spitterDao.findAll();
    }

    @Override
    public Reference findOne(long i) {


        return null;
    }
}
