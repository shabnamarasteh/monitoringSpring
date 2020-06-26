package org.j2os.monitor.modules.common.model.service;

import org.j2os.monitor.modules.common.model.entity.City;
import org.j2os.monitor.modules.common.model.repository.CityRepository;
import org.j2os.monitor.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class CityService implements ServiceInterface<City> {
    private CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    @Transactional
    public void add(City city) {
        this.cityRepository.save(city);
    }

    @Override
    public void update(City city) throws InvocationTargetException, IllegalAccessException {

    }

    @Override
    public List<City> findAll() {
        return null;
    }

    @Override
    public void delete(City city) {

    }

    @Override
    public City findOne(City city) {
        return null;
    }

    @Override
    public City findById(long id) {
        return null;
    }
}
