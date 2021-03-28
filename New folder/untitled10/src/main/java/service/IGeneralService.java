package service;

import javax.transaction.SystemException;
import java.util.List;

public interface IGeneralService<E> {
    List<E> getAll();

    E getById(int id);

    List<E> getByName(String name);

    boolean remove(int id);

    boolean update(int id, E e);

    int add(E e) throws SystemException;
}
