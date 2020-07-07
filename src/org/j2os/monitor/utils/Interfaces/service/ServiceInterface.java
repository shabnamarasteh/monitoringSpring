package org.j2os.monitor.utils.Interfaces.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ServiceInterface<T> {
    void add(T t);
    void update(T t) throws InvocationTargetException, IllegalAccessException;
    List<T> findAll();
    void delete(T t);
    T findOne(T t);
    Boolean existsById(long id);
    T findById(long id);
}
