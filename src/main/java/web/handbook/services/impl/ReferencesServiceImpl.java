package web.handbook.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.handbook.data.dao.ReferenceDao;
import web.handbook.data.models.Reference;
import web.handbook.data.models.entities.HibernateReference;
import web.handbook.services.ReferencesService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
@Slf4j
public class ReferencesServiceImpl
        implements ReferencesService {

    @Autowired
    private ReferenceDao referenceDao;

    @Autowired
    private ModelMapper modelMapper;

    private Map<String, String> mapUserAndPassword;

    @Override
    public Reference save(Reference reference) {
        log.debug("#### referenceDAO CREATE ####");
        log.debug("got reference {}", reference);
        HibernateReference hibernateReference = modelMapper.map(reference, HibernateReference.class);
        referenceDao.save(hibernateReference);
        Reference referenceSaved = modelMapper.map(hibernateReference, Reference.class);
        return referenceSaved;
    }

    @Override
    public Reference findByUsername(String reference) {
        HibernateReference hibernateReference = referenceDao.findOneByUserName(reference);
        Reference oneByName = modelMapper.map(hibernateReference, Reference.class);
        return oneByName;
    }

    @Override
    public List<Reference> findReferences(long max, int count) {
        return StreamSupport.stream(referenceDao.findAll().spliterator(), false)
                .map(s -> modelMapper.map(s, Reference.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(long id) {
        log.debug("#### Going to remove reference by id [{}] ####", id);
        referenceDao.deleteById(id);
    }
}
