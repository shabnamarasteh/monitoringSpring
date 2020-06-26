package org.j2os.monitor.modules.common.model.repository;

import org.j2os.monitor.modules.common.model.entity.State;
import org.j2os.monitor.utils.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class StateRepository  extends CrudRepository<State,Long> {
}
