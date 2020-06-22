package org.j2os.monitor.modules.alarm.model.repository;

import org.j2os.monitor.modules.alarm.model.entity.AlarmNote;
import org.j2os.monitor.utils.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AlarmNoteRepository extends CrudRepository<AlarmNote, Long> {
}
