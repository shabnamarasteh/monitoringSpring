package org.j2os.monitor.modules.device.model.service;

import org.j2os.monitor.modules.device.model.entity.DeviceModelProperty;
import org.j2os.monitor.modules.device.model.repository.DeviceModelPropertyRepository;
import org.j2os.monitor.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class DeviceModelPropertyService implements ServiceInterface<DeviceModelProperty> {
    private DeviceModelPropertyRepository deviceModelPropertyRepository;

    @Autowired
    public DeviceModelPropertyService(DeviceModelPropertyRepository deviceModelPropertyRepository) {
        this.deviceModelPropertyRepository = deviceModelPropertyRepository;
    }

    @Override
    public void add(DeviceModelProperty deviceModelProperty) {
        this.deviceModelPropertyRepository.save(deviceModelProperty);
    }

    @Override
    public void update(DeviceModelProperty deviceModelProperty) throws InvocationTargetException, IllegalAccessException {

    }

    @Override
    public List<DeviceModelProperty> findAll() {
        return null;
    }

    @Override
    public void delete(DeviceModelProperty deviceModelProperty) {

    }

    @Override
    public DeviceModelProperty findOne(DeviceModelProperty deviceModelProperty) {
        return null;
    }

    @Override
    public DeviceModelProperty findById(long id) {
        return null;
    }
}
