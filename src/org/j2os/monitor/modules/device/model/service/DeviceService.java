package org.j2os.monitor.modules.device.model.service;

import org.j2os.monitor.modules.common.MyBeanCopy;
import org.j2os.monitor.modules.device.model.entity.Device;
import org.j2os.monitor.modules.device.model.repository.DeviceRepository;
import org.j2os.monitor.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class DeviceService implements ServiceInterface<Device> {
    private DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    @Transactional
    public void add(Device device) {
        this.deviceRepository.save(device);
    }

    @Override
    @Transactional
    public void update(Device device) throws InvocationTargetException, IllegalAccessException {
        Device exist = this.deviceRepository.findOne(Device.class,device.getId());
        MyBeanCopy myBeanCopy = new MyBeanCopy();
        myBeanCopy.copyProperties(exist, device);
        this.deviceRepository.save(exist);
    }

    @Override
    public List<Device> findAll() {
        return this.deviceRepository.findAll(Device.class);
    }

    @Override
    @Transactional
    public void delete(Device device) {
        this.deviceRepository.delete(device);
    }

    @Override
    public Device findOne(Device device) {
        return this.deviceRepository.findOne(Device.class,device.getId());
    }

    @Override
    public Boolean existsById(long id) {
        return this.deviceRepository.existsById(Device.class,id);
    }

    @Override
    public Device findById(long id) {
        return this.deviceRepository.findOne(Device.class,id);
    }
}
