package org.j2os.monitor.modules.common.model.repository;

import org.j2os.monitor.modules.common.model.entity.City;
import org.j2os.monitor.utils.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CityRepository extends CrudRepository<City,Long> {
}
