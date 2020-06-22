package org.j2os.monitor.modules.admin.model.repository;

import org.j2os.monitor.modules.admin.model.entity.Admin;
import org.j2os.monitor.utils.CrudRepository;
import org.j2os.monitor.utils.Interfaces.repository.RepositoryInterface;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository extends CrudRepository<Admin, Long> {
}
