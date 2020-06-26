package org.j2os.monitor.modules.alarm.model.service;

import org.j2os.monitor.modules.alarm.model.entity.AlarmNote;
import org.j2os.monitor.modules.alarm.model.repository.AlarmNoteRepository;
import org.j2os.monitor.modules.common.MyBeanCopy;
import org.j2os.monitor.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class AlarmNoteService implements ServiceInterface<AlarmNote> {
    private AlarmNoteRepository alarmNoteRepository;

    @Autowired
    public AlarmNoteService(AlarmNoteRepository alarmNoteRepository) {
        this.alarmNoteRepository = alarmNoteRepository;
    }

    @Override
    @Transactional
    public void add(AlarmNote alarmNote) {
        this.alarmNoteRepository.save(alarmNote);
    }

    @Override
    @Transactional
    public void update(AlarmNote alarmNote) throws InvocationTargetException, IllegalAccessException {
        AlarmNote exist = this.alarmNoteRepository.findOne(AlarmNote.class,alarmNote.getId());
        MyBeanCopy myBeanCopy = new MyBeanCopy();
        myBeanCopy.copyProperties(exist, alarmNote);
        this.alarmNoteRepository.save(exist);
    }

    @Override
    public List<AlarmNote> findAll() {
        return this.alarmNoteRepository.findAll(AlarmNote.class);
    }

    @Override
    @Transactional
    public void delete(AlarmNote alarmNote) {
        this.alarmNoteRepository.delete(alarmNote);
    }

    @Override
    public AlarmNote findOne(AlarmNote alarmNote) {
        return this.alarmNoteRepository.findOne(AlarmNote.class,alarmNote.getId());
    }

    @Override
    public AlarmNote findById(long id) {
        return this.alarmNoteRepository.findOne(AlarmNote.class,id);

    }

}
