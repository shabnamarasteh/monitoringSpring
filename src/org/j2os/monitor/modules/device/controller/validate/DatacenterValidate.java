package org.j2os.monitor.modules.device.controller.validate;

import org.j2os.monitor.modules.common.model.entity.ValidateObject;
import org.j2os.monitor.modules.device.model.entity.Datacenter;
import org.j2os.monitor.modules.device.model.service.DatacenterService;
import org.j2os.monitor.utils.Interfaces.validate.ValidateInterface;
import org.j2os.monitor.utils.annotation.ValidationAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@ValidationAnnotation
public class DatacenterValidate implements ValidateInterface<Datacenter> {

    private DatacenterService datacenterService;

    @Autowired
    public DatacenterValidate(DatacenterService datacenterService) {
        this.datacenterService = datacenterService;
    }

    @Override
    public ValidateObject addValidate(Datacenter datacenter) {
        List<String> errorList = new ArrayList<>();
        ValidateObject validateObject = new ValidateObject();

        if(datacenter == null || datacenter.getName() == null || datacenter.getName().isEmpty()){
            errorList.add("Name is required");
        }
        if(datacenter == null || datacenter.getLocation() == null || datacenter.getLocation().isEmpty()){
            errorList.add("Location is required");
        }
        if(datacenter == null || datacenter.getCityId() == null || datacenter.getCityId().getId() == 0){
            errorList.add("City Id is required");
        }
        if(errorList.size()>0){
            validateObject.setResult("error");
        }else{
            validateObject.setResult("success");
        }

        validateObject.setFaultmessage(errorList);
        return validateObject;
    }

    @Override
    public ValidateObject updateValidate(Datacenter datacenter) {
        List<String> errorList = new ArrayList<>();
        ValidateObject validateObject = new ValidateObject();

        if(datacenter != null && datacenter.getName() != null && datacenter.getName().isEmpty()){
            errorList.add("Name is required");
        }
        if(datacenter != null && datacenter.getLocation() != null && datacenter.getLocation().isEmpty()){
            errorList.add("Location is required");
        }
        if(datacenter != null && datacenter.getCityId() != null && datacenter.getCityId().getId() == 0){
            errorList.add("City Id is required");
        }
        if(errorList.size()>0){
            validateObject.setResult("error");
        }else{
            validateObject.setResult("success");
        }

        validateObject.setFaultmessage(errorList);
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
    public ValidateObject deleteValidate(Datacenter datacenter) {
        List<String> errorList = new ArrayList<>();
        ValidateObject validateObject = new ValidateObject();

        if(!this.datacenterService.existsById(datacenter.getId())){
            errorList.add("Datacenter Id not defined");
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
    public ValidateObject findOneValidate(Datacenter datacenter) {
        List<String> errorList = new ArrayList<>();
        ValidateObject validateObject = new ValidateObject();

        if(!this.datacenterService.existsById(datacenter.getId())){
            errorList.add("Datacenter Id not defined");
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

        if(!this.datacenterService.existsById(id)){
            errorList.add("Datacenter Id not defined");
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
