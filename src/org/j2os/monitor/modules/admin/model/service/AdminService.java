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
    public void add(Admin admin) {
        this.adminRepository.save(admin);
    }

    @Override
    @Transactional
    public void update(Admin admin) {
        this.adminRepository.save(admin);
    }

    @Override
    public List<Admin> findAll() {
        return this.adminRepository.findAll(Admin.class);
    }

    @Override
    public Admin findOne(Admin admin) {
        return this.adminRepository.findOne(Admin.class,admin.getId());
    }

    @Override
    public Admin findById(long id) {
        return this.adminRepository.findOne(Admin.class,id);
    }

    @Override
    public void delete(Admin admin) {
        this.adminRepository.delete(admin);
    }

}
