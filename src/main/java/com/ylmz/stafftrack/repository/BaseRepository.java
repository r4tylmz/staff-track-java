package com.ylmz.stafftrack.repository;

import java.util.List;

public interface BaseRepository<T>{
    T getById(int id);
    List<T> getAll();
    T update(T entity);
    void delete(int id);
    T save(T entity);
    List<T> saveAll(List<T> entities);
}
