package org.j2os.monitor.modules.device.model.service;

import org.j2os.monitor.modules.common.MyBeanCopy;
import org.j2os.monitor.modules.device.model.entity.Rack;
import org.j2os.monitor.modules.device.model.repository.RackRepository;
import org.j2os.monitor.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class RackService implements ServiceInterface<Rack> {

    private RackRepository rackRepository;

    @Autowired
    public RackService(RackRepository rackRepository) {
        this.rackRepository = rackRepository;
    }

    @Override
    @Transactional
    public void add(Rack rack) {
        this.rackRepository.save(rack);
    }

    @Override
    @Transactional
    public void update(Rack rack) throws InvocationTargetException, IllegalAccessException {
        Rack exist = this.rackRepository.findOne(Rack.class,rack.getId());
        MyBeanCopy myBeanCopy = new MyBeanCopy();
        myBeanCopy.copyProperties(exist,rack);
        this.rackRepository.save(exist);
    }

    @Override
    public List<Rack> findAll() {
        return this.rackRepository.findAll(Rack.class);
    }

    @Override
    @Transactional
    public void delete(Rack rack) {
        this.rackRepository.delete(rack);
    }

    @Override
    public Rack findOne(Rack rack) {
        return this.rackRepository.findOne(Rack.class,rack.getId());
    }

    @Override
    public Boolean existsById(long id) {
        return this.rackRepository.existsById(Rack.class,id);
    }

    @Override
    public Rack findById(long id) {
        return this.rackRepository.findOne(Rack.class,id);
    }
}
