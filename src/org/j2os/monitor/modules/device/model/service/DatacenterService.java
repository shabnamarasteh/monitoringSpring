package org.j2os.monitor.modules.device.model.service;

import org.j2os.monitor.modules.device.model.entity.Datacenter;
import org.j2os.monitor.modules.device.model.repository.DatacenterRepository;
import org.j2os.monitor.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class DatacenterService implements ServiceInterface<Datacenter> {

    private DatacenterRepository datacenterRepository;
    @Autowired
    public DatacenterService(DatacenterRepository datacenterRepository) {
        this.datacenterRepository = datacenterRepository;
    }

    @Override
    public void add(Datacenter datacenter) {
        this.datacenterRepository.save(datacenter);
    }

    @Override
    public void update(Datacenter datacenter) throws InvocationTargetException, IllegalAccessException {
        this.datacenterRepository.update(datacenter);
    }

    @Override
    public List<Datacenter> findAll() {
        return this.datacenterRepository.findAll(Datacenter.class);
    }

    @Override
    public void delete(Datacenter datacenter) {
        this.datacenterRepository.delete(datacenter);
    }

    @Override
    public Datacenter findOne(Datacenter datacenter) {
        return this.datacenterRepository.findOne(Datacenter.class,datacenter.getId());
    }

    @Override
    public Boolean existsById(long id) {
        return this.datacenterRepository.existsById(Datacenter.class,id);
    }

    @Override
    public Datacenter findById(long id) {
        return this.datacenterRepository.findOne(Datacenter.class,id);
    }
}
