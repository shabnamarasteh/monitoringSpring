package org.j2os.monitor.modules.device.model.repository;

import org.j2os.monitor.modules.device.model.entity.Rack;
import org.j2os.monitor.utils.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RackRepository extends CrudRepository<Rack,Long> {
}
