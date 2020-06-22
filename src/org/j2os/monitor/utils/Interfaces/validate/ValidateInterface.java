package org.j2os.monitor.utils.Interfaces.validate;

import org.j2os.monitor.modules.common.model.entity.ValidateObject;

public interface ValidateInterface<T> {
    ValidateObject addValidate(T t);
    ValidateObject updateValidate(T t);
    ValidateObject findAllValidate();
    ValidateObject deleteValidate(T t);
    ValidateObject findOneValidate(T t);
    ValidateObject findByIdValidate(long id);
}
