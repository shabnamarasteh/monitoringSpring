package org.j2os.monitor.modules.alarm.controller.validate;

import org.j2os.monitor.modules.alarm.model.entity.AlarmNote;
import org.j2os.monitor.modules.common.model.entity.ValidateObject;
import org.j2os.monitor.utils.Interfaces.validate.ValidateInterface;
import org.j2os.monitor.utils.annotation.ValidationAnnotation;

@ValidationAnnotation
public class AlarmNoteValidate implements ValidateInterface<AlarmNote> {
    @Override
    public ValidateObject addValidate(AlarmNote alarmNote) {
        return null;
    }

    @Override
    public ValidateObject updateValidate(AlarmNote alarmNote) {
        return null;
    }

    @Override
    public ValidateObject findAllValidate() {
        return null;
    }

    @Override
    public ValidateObject deleteValidate(AlarmNote alarmNote) {
        return null;
    }

    @Override
    public ValidateObject findOneValidate(AlarmNote alarmNote) {
        return null;
    }

    @Override
    public ValidateObject findByIdValidate(long id) {
        return null;
    }
}
