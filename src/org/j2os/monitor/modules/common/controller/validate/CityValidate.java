package org.j2os.monitor.modules.common.controller.validate;

import org.j2os.monitor.modules.common.model.entity.City;
import org.j2os.monitor.modules.common.model.entity.ValidateObject;
import org.j2os.monitor.modules.common.model.service.CityService;
import org.j2os.monitor.utils.Interfaces.validate.ValidateInterface;
import org.j2os.monitor.utils.annotation.ValidationAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@ValidationAnnotation
public class CityValidate implements ValidateInterface<City> {
    private CityService cityService;

    @Autowired
    public CityValidate(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public ValidateObject addValidate(City city) {
        List<String> errorList = new ArrayList<>();
        ValidateObject validateObject = new ValidateObject();

        if(city == null || city.getName() == null ){
            errorList.add("Name is required");
        }
        if(city == null || city.getStateId() == null ||city.getStateId().getId() == 0 ){
            errorList.add("State is required");
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
    public ValidateObject updateValidate(City city) {
        List<String> errorList = new ArrayList<>();
        ValidateObject validateObject = new ValidateObject();

        if(city != null && city.getName() != null && city.getName().isEmpty() ){
            errorList.add("Name is required");
        }
        if(city != null && city.getStateId() != null  && city.getStateId().getId() == 0 ){
            errorList.add("State is required");
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
    public ValidateObject deleteValidate(City city) {
        List<String> errorList = new ArrayList<>();
        ValidateObject validateObject = new ValidateObject();

        if(city == null || !this.cityService.existsById(city.getId())){
            errorList.add("City Id not defined");
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
    public ValidateObject findOneValidate(City city) {
        List<String> errorList = new ArrayList<>();
        ValidateObject validateObject = new ValidateObject();

        if(city == null || !this.cityService.existsById(city.getId())){
            errorList.add("City Id not defined");
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

        if(!this.cityService.existsById(id)){
            errorList.add("City Id not defined");
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
