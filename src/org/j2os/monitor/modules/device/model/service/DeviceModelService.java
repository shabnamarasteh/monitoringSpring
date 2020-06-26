package org.j2os.monitor.modules.device.model.service;

import org.j2os.monitor.modules.device.model.entity.DeviceModel;
import org.j2os.monitor.modules.device.model.repository.DeviceModelRepository;
import org.j2os.monitor.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class DeviceModelService implements ServiceInterface<DeviceModel> {
    private DeviceModelRepository deviceModelRepository;

    @Autowired
    public DeviceModelService(DeviceModelRepository deviceModelRepository) {
        this.deviceModelRepository = deviceModelRepository;
    }

    @Override
    public void add(DeviceModel deviceModel) {
        this.deviceModelRepository.save(deviceModel);
    }

    @Override
    public void update(DeviceModel deviceModel) throws InvocationTargetException, IllegalAccessException {

    }

    @Override
    public List<DeviceModel> findAll() {
        return null;
    }

    @Override
    public void delete(DeviceModel deviceModel) {

    }

    @Override
    public DeviceModel findOne(DeviceModel deviceModel) {
        return null;
    }

    @Override
    public DeviceModel findById(long id) {
        return null;
    }
}
