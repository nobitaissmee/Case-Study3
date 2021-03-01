package service;

import java.util.List;

public interface BaseService<T> {

    List<T> findAll();

    T findById(int id);

    void save(T t);

    void update(T t);

    void remove(int id);
}
