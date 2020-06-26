package org.j2os.monitor.modules.common.model.service;

import org.j2os.monitor.modules.common.model.entity.State;
import org.j2os.monitor.modules.common.model.repository.StateRepository;
import org.j2os.monitor.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class StateService implements ServiceInterface<State> {
    private StateRepository stateRepository;

    @Autowired
    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public void add(State state) {

    }

    @Override
    public void update(State state) throws InvocationTargetException, IllegalAccessException {

    }

    @Override
    public List<State> findAll() {
        return null;
    }

    @Override
    public void delete(State state) {

    }

    @Override
    public State findOne(State state) {
        return null;
    }

    @Override
    public State findById(long id) {
        return null;
    }
}
