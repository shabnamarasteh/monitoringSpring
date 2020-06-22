package org.j2os.monitor.modules.admin.model.repository;

import org.j2os.monitor.modules.admin.model.entity.Role;
import org.j2os.monitor.utils.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepository extends CrudRepository<Role, Long> {
}
