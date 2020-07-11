package org.j2os.monitor.modules.device.controller.validate;

import org.j2os.monitor.modules.common.model.entity.ValidateObject;
import org.j2os.monitor.modules.device.model.entity.DeviceGroup;
import org.j2os.monitor.modules.device.model.service.DeviceGroupService;
import org.j2os.monitor.utils.Interfaces.validate.ValidateInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class DeviceGroupValidate implements ValidateInterface<DeviceGroup> {
    private DeviceGroupService deviceGroupService;
    @Autowired
    public DeviceGroupValidate(DeviceGroupService deviceGroupService) {
        this.deviceGroupService = deviceGroupService;
    }

    @Override
    public ValidateObject addValidate(DeviceGroup deviceGroup) {
        List<String> errorList = new ArrayList<>();
        ValidateObject validateObject = new ValidateObject();

        if(deviceGroup == null || deviceGroup.getName() == null || deviceGroup.getName().isEmpty()){
            errorList.add("Name is required");
        }
        // check model ?

        if(errorList.size() > 0){
            validateObject.setFaultmessage(errorList);
            validateObject.setResult("error");
        }else{
            validateObject.setResult("success");
        }
        return validateObject;
    }

    @Override
    public ValidateObject updateValidate(DeviceGroup deviceGroup) {
        List<String> errorList = new ArrayList<>();
        ValidateObject validateObject = new ValidateObject();

        if(deviceGroup != null && deviceGroup.getName() == null && deviceGroup.getName().isEmpty()){
            errorList.add("Name is required");
        }
        // check model ?

        if(errorList.size() > 0){
            validateObject.setFaultmessage(errorList);
            validateObject.setResult("error");
        }else{
            validateObject.setResult("success");
        }
        return validateObject;
    }

    @Override
    public ValidateObject findAllValidate() {
        List<String> errorList = new ArrayList<>();
        ValidateObject validateObject = new ValidateObject();
        if(errorList.size() > 0){
            validateObject.setFaultmessage(errorList);
            validateObject.setResult("error");
        }else{
            validateObject.setResult("success");
        }
        return validateObject;
    }

    @Override
    public ValidateObject deleteValidate(DeviceGroup deviceGroup) {
        List<String> errorList = new ArrayList<>();
        ValidateObject validateObject = new ValidateObject();

        if(deviceGroup == null || !this.deviceGroupService.existsById(deviceGroup.getId())){
            errorList.add("Device Group not defined");
        }

        if(errorList.size() > 0){
            validateObject.setFaultmessage(errorList);
            validateObject.setResult("error");
        }else{
            validateObject.setResult("success");
        }
        return validateObject;
    }

    @Override
    public ValidateObject findOneValidate(DeviceGroup deviceGroup) {
        List<String> errorList = new ArrayList<>();
        ValidateObject validateObject = new ValidateObject();

        if(deviceGroup == null || !this.deviceGroupService.existsById(deviceGroup.getId())){
            errorList.add("Device Group not defined");
        }

        if(errorList.size() > 0){
            validateObject.setFaultmessage(errorList);
            validateObject.setResult("error");
        }else{
            validateObject.setResult("success");
        }
        return validateObject;
    }

    @Override
    public ValidateObject findByIdValidate(long id) {
        List<String> errorList = new ArrayList<>();
        ValidateObject validateObject = new ValidateObject();

        if(!this.deviceGroupService.existsById(id)){
            errorList.add("Device Group not defined");
        }

        if(errorList.size() > 0){
            validateObject.setFaultmessage(errorList);
            validateObject.setResult("error");
        }else{
            validateObject.setResult("success");
        }
        return validateObject;
    }
}
