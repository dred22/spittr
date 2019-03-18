package spittr.data.dao;

import java.util.List;

public interface GenericDao<T> {

    public abstract T create(T reference);

    public abstract boolean delete(T reference);

    public abstract int update(T reference);

    public abstract T findOneByUsername(String username);

    public abstract T findById(Long id);

    public abstract List<T> findAll();
}