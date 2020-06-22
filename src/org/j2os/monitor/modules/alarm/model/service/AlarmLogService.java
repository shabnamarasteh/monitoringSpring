package org.j2os.monitor.modules.alarm.model.service;

import org.j2os.monitor.modules.alarm.model.entity.AlarmLog;
import org.j2os.monitor.modules.alarm.model.repository.AlarmLogRepository;
import org.j2os.monitor.modules.common.MyBeanCopy;
import org.j2os.monitor.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class AlarmLogService  implements ServiceInterface<AlarmLog> {
    private AlarmLogRepository alarmLogRepository;
    @Autowired
    public AlarmLogService(AlarmLogRepository alarmLogRepository) {
        this.alarmLogRepository = alarmLogRepository;
    }

    @Override
    @Transactional
    public AlarmLog add(AlarmLog alarmLog) {
        this.alarmLogRepository.save(alarmLog);
        return this.alarmLogRepository.findOne(AlarmLog.class,alarmLog.getId());
    }

    @Override
    @Transactional
    public AlarmLog update(AlarmLog alarmLog) throws InvocationTargetException, IllegalAccessException {
        this.alarmLogRepository.save(alarmLog);
        return this.alarmLogRepository.findOne(AlarmLog.class,alarmLog.getId());
    }

    @Override
    public List<AlarmLog> findAll() {
        return this.alarmLogRepository.findAll(AlarmLog.class);
    }

    @Override
    @Transactional
    public List<AlarmLog> delete(AlarmLog alarmLog) {
        this.alarmLogRepository.delete(alarmLog);
        return this.alarmLogRepository.findAll(AlarmLog.class);
    }

    @Override
    public AlarmLog findOne(AlarmLog alarmLog) {
        return this.alarmLogRepository.findOne(AlarmLog.class,alarmLog.getId());
    }

    @Override
    public AlarmLog findById(long id) {
        return this.alarmLogRepository.findOne(AlarmLog.class,id);
    }
}
