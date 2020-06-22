package org.j2os.monitor.modules.alarm.controller.validate;

import org.j2os.monitor.modules.alarm.model.entity.AlarmLog;
import org.j2os.monitor.modules.common.model.entity.ValidateObject;
import org.j2os.monitor.utils.Interfaces.validate.ValidateInterface;
import org.j2os.monitor.utils.annotation.ValidationAnnotation;

@ValidationAnnotation
public class AlarmLogValidate implements ValidateInterface<AlarmLog> {
    @Override
    public ValidateObject addValidate(AlarmLog alarmLog) {
        return null;
    }

    @Override
    public ValidateObject updateValidate(AlarmLog alarmLog) {
        return null;
    }

    @Override
    public ValidateObject findAllValidate() {
        return null;
    }

    @Override
    public ValidateObject deleteValidate(AlarmLog alarmLog) {
        return null;
    }

    @Override
    public ValidateObject findOneValidate(AlarmLog alarmLog) {
        return null;
    }

    @Override
    public ValidateObject findByIdValidate(long id) {
        return null;
    }
}
