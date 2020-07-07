package org.j2os.monitor.modules.device.controller.rest;

import org.j2os.monitor.modules.common.model.entity.ValidateObject;
import org.j2os.monitor.modules.device.controller.validate.DatacenterValidate;
import org.j2os.monitor.modules.device.model.entity.Datacenter;
import org.j2os.monitor.modules.device.model.service.DatacenterService;
import org.j2os.monitor.utils.ApiResponse;
import org.j2os.monitor.utils.Interfaces.controller.RestControllerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/v1/device/datacenter")
public class DatacenterRestController implements RestControllerInterface {
    private DatacenterService datacenterService;
    private DatacenterValidate datacenterValidate;

    @Autowired
    public DatacenterRestController(DatacenterService datacenterService, DatacenterValidate datacenterValidate) {
        this.datacenterService = datacenterService;
        this.datacenterValidate = datacenterValidate;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll(){
        ValidateObject validateObject = this.datacenterValidate.findAllValidate();
        if(validateObject.getResult().equals("error")){
            return new ApiResponse("error",101,validateObject.getFaultmessage()).getFaultResponse();
        }
        List<Datacenter> datacenterList = this.datacenterService.findAll();
        return new ApiResponse("success",new ArrayList(datacenterList)).getSuccessResponse();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Object findOne(@PathVariable("id") long id){
        ValidateObject validateObject = this.datacenterValidate.findByIdValidate(id);
        if(validateObject.getResult().equals("error")){
            return new ApiResponse("error",101,validateObject.getFaultmessage()).getFaultResponse();
        }
        Datacenter datacenter = this.datacenterService.findById(id);
        return new ApiResponse("success", Arrays.asList(datacenter)).getSuccessResponse();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Object delete(@PathVariable("id") long id){
        ValidateObject idValidateObject = this.datacenterValidate.findByIdValidate(id);
        if(idValidateObject.getResult().equals("error")){
            return new ApiResponse("error",101,idValidateObject.getFaultmessage()).getFaultResponse();
        }
        Datacenter datacenter = this.datacenterService.findById(id);
        ValidateObject validateObject = this.datacenterValidate.deleteValidate(datacenter);
        if(validateObject.getResult().equals("error")){
            return new ApiResponse("error",101,validateObject.getFaultmessage()).getFaultResponse();
        }
        this.datacenterService.delete(datacenter);
        return new ApiResponse("success",Arrays.asList(datacenter)).getSuccessResponse();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Object update(@PathVariable("id") long id, @RequestBody Datacenter datacenter){
        ValidateObject idValidateObject = this.datacenterValidate.findByIdValidate(id);
        if(idValidateObject.getResult().equals("error")){
            return new ApiResponse("error",101,idValidateObject.getFaultmessage()).getFaultResponse();
        }
        datacenter.setId(id);
        ValidateObject validateObject = this.datacenterValidate.updateValidate(datacenter);
        if(validateObject.getResult().equals("error")){
            return new ApiResponse("error",101,validateObject.getFaultmessage()).getFaultResponse();
        }
        try {
            this.datacenterService.update(datacenter);
            return new ApiResponse("success",Arrays.asList(datacenter)).getSuccessResponse();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return new ApiResponse("error",Arrays.asList("An error occurrd during update")).getSuccessResponse();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return new ApiResponse("error",Arrays.asList("An error occurrd during update")).getSuccessResponse();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object add(@RequestBody Datacenter datacenter){
        ValidateObject validateObject = this.datacenterValidate.addValidate(datacenter);
        if(validateObject.getResult().equals("error")){
            return new ApiResponse("error",101,validateObject.getFaultmessage()).getFaultResponse();
        }
//        ValidateObject cityValidate = this.
        this.datacenterService.add(datacenter);
        return new ApiResponse("success",Arrays.asList(datacenter)).getSuccessResponse();
    }
}
