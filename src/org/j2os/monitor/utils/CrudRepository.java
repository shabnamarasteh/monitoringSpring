package org.j2os.monitor.utils;

import javax.persistence.*;
import java.util.List;

public class CrudRepository<T,I> {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public void save(T t) {
        entityManager.persist(t);
    }

    public void update(T t) {
        entityManager.merge(t);
        System.out.println("Update Entity");
    }

    public void delete(T t) {
        t = entityManager.merge(t);
        entityManager.remove(t);
        System.out.println("Delete Entity");
    }

    public List<T> findAll(Class<T> tClass) {
        Query query = entityManager.createQuery("select entity from " + tClass.getAnnotation(Entity.class).name() + " entity");
        System.out.println("FindAll Entity");
        return query.getResultList();
    }

    public T findOne(Class<T> tClass, I id) {
        System.out.println("FindOne Entity");
        return entityManager.find(tClass, id);
    }

    public Boolean existsById(Class<T> tClass,I id) {
        System.out.println("FindOne Entity");
        if(entityManager.find(tClass,id) != null){
            return true;
        }
        return false;
    }
}
