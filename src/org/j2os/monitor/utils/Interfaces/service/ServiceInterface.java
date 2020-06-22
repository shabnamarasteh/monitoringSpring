package org.j2os.monitor.utils.Interfaces.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ServiceInterface<T> {
    T add(T t);
    T update(T t) throws InvocationTargetException, IllegalAccessException;
    List<T> findAll();
    List<T> delete(T t);
    T findOne(T t);
    T findById(long id);
}
