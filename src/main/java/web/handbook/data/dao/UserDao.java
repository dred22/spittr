package web.handbook.data.dao;

import org.springframework.data.repository.CrudRepository;
import web.handbook.data.models.entities.HibernateUser;

public interface UserDao extends CrudRepository<HibernateUser, String> {
}
