package org.j2os.monitor.modules.device.model.service;

import org.j2os.monitor.modules.device.model.entity.DeviceGroup;
import org.j2os.monitor.modules.device.model.repository.DeviceGroupRepository;
import org.j2os.monitor.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class DeviceGroupService implements ServiceInterface<DeviceGroup> {
    private DeviceGroupRepository deviceGroupRepository;

    @Autowired
    public DeviceGroupService(DeviceGroupRepository deviceGroupRepository) {
        this.deviceGroupRepository = deviceGroupRepository;
    }

    @Override
    public void add(DeviceGroup deviceGroup) {
        this.deviceGroupRepository.save(deviceGroup);
    }

    @Override
    public void update(DeviceGroup deviceGroup) throws InvocationTargetException, IllegalAccessException {

    }

    @Override
    public List<DeviceGroup> findAll() {
        return null;
    }

    @Override
    public void delete(DeviceGroup deviceGroup) {

    }

    @Override
    public DeviceGroup findOne(DeviceGroup deviceGroup) {
        return null;
    }

    @Override
    public DeviceGroup findById(long id) {
        return null;
    }
}
