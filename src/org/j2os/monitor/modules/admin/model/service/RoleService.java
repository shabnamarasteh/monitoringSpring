package org.j2os.monitor.modules.admin.model.service;

import org.j2os.monitor.modules.admin.model.entity.Role;
import org.j2os.monitor.modules.admin.model.repository.RoleRepository;
import org.j2os.monitor.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements ServiceInterface<Role> {
    private RoleRepository roleRepository;
    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role add(Role role) {
        return null;
    }

    @Override
    public Role update(Role role) {
        return null;
    }

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public Role findOne(Role role) {
        return null;
    }

    @Override
    public Role findById(long id) {
        return null;
    }

    @Override
    public List<Role> delete(Role role) {
        return null;
    }

}

