package ix.smart.demo.DAO;

import java.util.List;

public interface DbService<T> {

    T add(T t);
    Boolean delete(Long id);
    T findOneById(Long id);
    T findOneByName(String name);
    List<T> findAll();

}
