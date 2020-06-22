package org.j2os.monitor.modules.admin.model.service;

import org.j2os.monitor.modules.admin.model.entity.Admin;
import org.j2os.monitor.modules.admin.model.repository.AdminRepository;
import org.j2os.monitor.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService implements ServiceInterface<Admin> {
    private AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin add(Admin admin) {
        this.adminRepository.save(admin);
        return this.adminRepository.findOne(Admin.class,admin.getId());
    }

    @Override
    @Transactional
    public Admin update(Admin admin) {
        this.adminRepository.save(admin);
        return this.adminRepository.findOne(Admin.class,admin.getId());

    }

    @Override
    public List<Admin> findAll() {
        return null;
    }

    @Override
    public Admin findOne(Admin admin) {
        return null;
    }

    @Override
    public Admin findById(long id) {
        return null;
    }

    @Override
    public List<Admin> delete(Admin admin) {
        return null;
    }

}
