package ra.model.service;

import java.util.Optional;

public interface IGenericService<T,E> {
    Iterable<T> findAll();

    Optional<T> findById(E id);
    T save(T t);
    void delete (E id);
}
