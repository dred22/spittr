package web.handbook.services;

import web.handbook.data.models.Reference;

import java.util.List;

public interface ReferencesService {

    Reference save(Reference reference);

    Reference findByUsername(String reference);

    List<Reference> findReferences(long max, int count);

    Reference findOne(long i);
}