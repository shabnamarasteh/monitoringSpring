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
    public AlarmNote add(AlarmNote alarmNote) {
        this.alarmNoteRepository.save(alarmNote);
        return this.alarmNoteRepository.findOne(AlarmNote.class,alarmNote.getId());
    }

    @Override
    @Transactional
    public AlarmNote update(AlarmNote alarmNote) throws InvocationTargetException, IllegalAccessException {
        AlarmNote exist = this.alarmNoteRepository.findOne(AlarmNote.class,alarmNote.getId());
        MyBeanCopy myBeanCopy = new MyBeanCopy();
        myBeanCopy.copyProperties(exist, alarmNote);
        this.alarmNoteRepository.save(exist);
        return exist;
    }

    @Override
    public List<AlarmNote> findAll() {
        return this.alarmNoteRepository.findAll(AlarmNote.class);
    }

    @Override
    @Transactional
    public List<AlarmNote> delete(AlarmNote alarmNote) {
        this.alarmNoteRepository.delete(alarmNote);
        return this.alarmNoteRepository.findAll(AlarmNote.class);
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
