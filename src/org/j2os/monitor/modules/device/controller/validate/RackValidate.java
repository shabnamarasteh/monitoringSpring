package org.j2os.monitor.modules.device.controller.validate;

import org.j2os.monitor.modules.common.model.entity.ValidateObject;
import org.j2os.monitor.modules.device.model.entity.Rack;
import org.j2os.monitor.modules.device.model.repository.RackRepository;
import org.j2os.monitor.modules.device.model.service.RackService;
import org.j2os.monitor.utils.Interfaces.validate.ValidateInterface;
import org.j2os.monitor.utils.annotation.ValidationAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@ValidationAnnotation
public class RackValidate implements ValidateInterface<Rack> {
    private RackService rackService;

    @Autowired
    public RackValidate(RackService rackService) {
        this.rackService = rackService;
    }

    @Override
    public ValidateObject addValidate(Rack rack) {
        List<String> errorList = new ArrayList<>();
        ValidateObject validateObject = new ValidateObject();

        if(rack == null || rack.getName() == null || rack.getName().isEmpty()){
            errorList.add("Rack Name is required");
        }
        if(rack == null || rack.getMax_unit() == 0){
            errorList.add("Max Unit is required");
        }
        if(rack == null || rack.getDatacenterId() == null || rack.getDatacenterId().getId() == 0){
            errorList.add("Datacenter Id is required");
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
    public ValidateObject updateValidate(Rack rack) {
        List<String> errorList = new ArrayList<>();
        ValidateObject validateObject = new ValidateObject();

        if(rack != null && rack.getName() != null && rack.getName().isEmpty()){
            errorList.add("Rack Name is required");
        }
        if(rack != null && rack.getMax_unit() == 0){
            errorList.add("Max Unit is required");
        }
        if(rack != null && rack.getDatacenterId() != null && rack.getDatacenterId().getId() == 0){
            errorList.add("Datacenter Id is required");
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
    public ValidateObject deleteValidate(Rack rack) {
        List<String> errorList = new ArrayList<>();
        ValidateObject validateObject = new ValidateObject();

        if(!this.rackService.existsById(rack.getId())){
            errorList.add("Rack Id not defined");
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
    public ValidateObject findOneValidate(Rack rack) {
        List<String> errorList = new ArrayList<>();
        ValidateObject validateObject = new ValidateObject();

        if(!this.rackService.existsById(rack.getId())){
            errorList.add("Rack Id not defined");
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

        if(!this.rackService.existsById(id)){
            errorList.add("Rack Id not defined");
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
