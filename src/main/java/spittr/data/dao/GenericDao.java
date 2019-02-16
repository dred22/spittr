package spittr.data.dao;

public interface GenericDao<T> {
		
	  public abstract T create(T spitter);

	  public abstract boolean delete(T spitter);

	  public abstract int update(T spitter);

	  public abstract T findOneByUsername(String username);
	  
	  public abstract T findById(Long id);
}