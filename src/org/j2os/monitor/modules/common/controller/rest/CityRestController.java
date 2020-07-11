package org.j2os.monitor.modules.common.controller.rest;

import org.j2os.monitor.modules.common.controller.validate.CityValidate;
import org.j2os.monitor.modules.common.model.entity.City;
import org.j2os.monitor.modules.common.model.entity.ValidateObject;
import org.j2os.monitor.modules.common.model.service.CityService;
import org.j2os.monitor.utils.ApiResponse;
import org.j2os.monitor.utils.Interfaces.controller.RestControllerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/common/city")
public class CityRestController  implements RestControllerInterface {
    private CityService cityService;
    private CityValidate cityValidate;

    @Autowired
    public CityRestController(CityService cityService, CityValidate cityValidate) {
        this.cityService = cityService;
        this.cityValidate = cityValidate;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll(){
        ValidateObject validateObject = this.cityValidate.findAllValidate();
        if(validateObject.getResult().equals("error")){
            return new ApiResponse("error",101,validateObject.getFaultmessage()).getFaultResponse();
        }
        List<City> cityList = this.cityService.findAll();
        return new ApiResponse("success",new ArrayList(cityList)).getSuccessResponse();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Object findOne(@PathVariable("id") long id){
        ValidateObject validateObject = this.cityValidate.findByIdValidate(id);
        if(validateObject.getResult().equals("error")){
            return new ApiResponse("error",101,validateObject.getFaultmessage()).getFaultResponse();
        }
        City city = this.cityService.findById(id);
        return new ApiResponse("success", new ArrayList(Arrays.asList(city))).getSuccessResponse();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Object delete(@PathVariable("id") long id){
        ValidateObject idValidateObject = this.cityValidate.findByIdValidate(id);
        if(idValidateObject.getResult().equals("error")){
            return new ApiResponse("error",101,idValidateObject.getFaultmessage()).getFaultResponse();
        }
        City city = this.cityService.findById(id);
        ValidateObject validateObject = this.cityValidate.deleteValidate(city);
        if(validateObject.getResult().equals("error")){
            return new ApiResponse("error",101,validateObject.getFaultmessage()).getFaultResponse();
        }
        this.cityService.delete(city);
        return new ApiResponse("success",new ArrayList(Arrays.asList(city))).getSuccessResponse();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Object update(@PathVariable("id") long id, @RequestBody City city){
        ValidateObject idValidateObject = this.cityValidate.findByIdValidate(id);
        if(idValidateObject.getResult().equals("error")){
            return new ApiResponse("error",101,idValidateObject.getFaultmessage()).getFaultResponse();
        }
        city.setId(id);
        ValidateObject validateObject = this.cityValidate.updateValidate(city);
        if(validateObject.getResult().equals("error")){
            return new ApiResponse("error",101,validateObject.getFaultmessage()).getFaultResponse();
        }
        try {
            this.cityService.update(city);
            return new ApiResponse("success",new ArrayList(Arrays.asList(city))).getSuccessResponse();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return new ApiResponse("error",new ArrayList(Arrays.asList("An error occurrd during update"))).getSuccessResponse();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return new ApiResponse("error",new ArrayList(Arrays.asList("An error occurrd during update"))).getSuccessResponse();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object add(@RequestBody City city){
        ValidateObject validateObject = this.cityValidate.addValidate(city);
        if(validateObject.getResult().equals("error")){
            return new ApiResponse("error",101,validateObject.getFaultmessage()).getFaultResponse();
        }
        this.cityService.add(city);
        return new ApiResponse("success",new ArrayList(Arrays.asList(city))).getSuccessResponse();
    }
}
