package com.ylmz.stafftrack.service;

import java.util.List;

public interface BaseService<T> {
    T getById(int id);
    List<T> getAll();
    T update(T entity);
    void delete(int id);
    T save(T entity);
    List<T> saveAll(List<T> entities);
}
