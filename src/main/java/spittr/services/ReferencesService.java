package spittr.services;

import spittr.data.models.Reference;

import java.util.List;

public interface ReferencesService {

    Reference save(Reference reference);

    Reference findByUsername(String reference);

    List<Reference> findReferences(long max, int count);

    Reference findOne(long i);
}