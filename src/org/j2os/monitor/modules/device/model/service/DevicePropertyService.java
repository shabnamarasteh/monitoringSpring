package org.j2os.monitor.modules.device.model.service;

import org.j2os.monitor.modules.device.model.entity.DeviceProperty;
import org.j2os.monitor.modules.device.model.repository.DevicePropertyRepository;
import org.j2os.monitor.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class DevicePropertyService  implements ServiceInterface<DeviceProperty> {
    private DevicePropertyRepository devicePropertyRepository;

    @Autowired
    public DevicePropertyService(DevicePropertyRepository devicePropertyRepository) {
        this.devicePropertyRepository = devicePropertyRepository;
    }

    @Override
    @Transactional
    public void add(DeviceProperty deviceProperty) {
        this.devicePropertyRepository.save(deviceProperty);
    }

    @Override
    @Transactional
    public void update(DeviceProperty deviceProperty) throws InvocationTargetException, IllegalAccessException {

    }

    @Override
    public List<DeviceProperty> findAll() {
        return null;
    }

    @Override
    public void delete(DeviceProperty deviceProperty) {

    }

    @Override
    public DeviceProperty findOne(DeviceProperty deviceProperty) {
        return null;
    }

    @Override
    public DeviceProperty findById(long id) {
        return null;
    }
}
