package DAO;

import java.util.List;

/**
 *
 * @author alba_
 */
public interface DAO<T> {
    public int add(T t);
    public T getById(int id);
    public List<T> getAll();
    public int update(T t);
    public int delete(int id);
    
    
}
