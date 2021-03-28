package product_manager.service;

import java.util.List;

public interface IGeneralService<E> {
    List<E> findAll();

    boolean remove(Long id);

    E add(E e);

    E update(Long id, E e);

    E findById(Long id);
}
