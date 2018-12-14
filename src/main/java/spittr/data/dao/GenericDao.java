package spittr.data.dao;

public interface GenericDao<T> {
		
	  public abstract T create(T obj);

	  public abstract boolean delete(T obj);

	  public abstract int update(T obj);

	  public abstract T findOneByUsername(String username);
	  
	  public abstract T findById(Long id);
}