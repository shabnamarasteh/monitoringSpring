package org.j2os.monitor.modules.device.controller.rest;

import org.j2os.monitor.modules.common.model.entity.ValidateObject;
import org.j2os.monitor.modules.device.controller.validate.DatacenterValidate;
import org.j2os.monitor.modules.device.controller.validate.RackValidate;
import org.j2os.monitor.modules.device.model.entity.Datacenter;
import org.j2os.monitor.modules.device.model.entity.Rack;
import org.j2os.monitor.modules.device.model.service.DatacenterService;
import org.j2os.monitor.modules.device.model.service.RackService;
import org.j2os.monitor.utils.ApiResponse;
import org.j2os.monitor.utils.Interfaces.controller.RestControllerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/device/rack")
public class RackRestController implements RestControllerInterface {
    private RackService rackService;
    private RackValidate rackValidate;
    private DatacenterService datacenterService;
    private DatacenterValidate datacenterValidate;

    @Autowired
    public RackRestController(RackService rackService, RackValidate rackValidate,
                              DatacenterService datacenterService, DatacenterValidate datacenterValidate) {
        this.rackService = rackService;
        this.rackValidate = rackValidate;
        this.datacenterService = datacenterService;
        this.datacenterValidate = datacenterValidate;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll(){
        ValidateObject validateObject = this.rackValidate.findAllValidate();
        if(validateObject.getResult().equals("error")){
            return new ApiResponse("error",101,validateObject.getFaultmessage()).getFaultResponse();
        }
        List<Rack> rackList = this.rackService.findAll();
        return new ApiResponse("success",new ArrayList(rackList)).getSuccessResponse();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Object findOne(@PathVariable("id") long id){
        ValidateObject validateObject = this.rackValidate.findByIdValidate(id);
        if(validateObject.getResult().equals("error")){
            return new ApiResponse("error",101,validateObject.getFaultmessage()).getFaultResponse();
        }
        Rack rack = this.rackService.findById(id);
        return new ApiResponse("success", new ArrayList(Arrays.asList(rack))).getSuccessResponse();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Object delete(@PathVariable("id") long id){
        ValidateObject idValidateObject = this.rackValidate.findByIdValidate(id);
        if(idValidateObject.getResult().equals("error")){
            return new ApiResponse("error",101,idValidateObject.getFaultmessage()).getFaultResponse();
        }
        Rack rack = this.rackService.findById(id);
        ValidateObject validateObject = this.rackValidate.deleteValidate(rack);
        if(validateObject.getResult().equals("error")){
            return new ApiResponse("error",101,validateObject.getFaultmessage()).getFaultResponse();
        }
        this.rackService.delete(rack);
        return new ApiResponse("success",new ArrayList(Arrays.asList(rack))).getSuccessResponse();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Object update(@PathVariable("id") long id, @RequestBody Rack rack){
        ValidateObject idValidateObject = this.rackValidate.findByIdValidate(id);
        if(idValidateObject.getResult().equals("error")){
            return new ApiResponse("error",101,idValidateObject.getFaultmessage()).getFaultResponse();
        }
        rack.setId(id);
        ValidateObject validateObject = this.rackValidate.updateValidate(rack);
        if(validateObject.getResult().equals("error")){
            return new ApiResponse("error",101,validateObject.getFaultmessage()).getFaultResponse();
        }
        try {
            this.rackService.update(rack);
            return new ApiResponse("success",new ArrayList(Arrays.asList(rack))).getSuccessResponse();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return new ApiResponse("error",Arrays.asList("An error occurrd during update")).getSuccessResponse();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return new ApiResponse("error",Arrays.asList("An error occurrd during update")).getSuccessResponse();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object add(@RequestBody Rack rack){
        ValidateObject validateObject = this.rackValidate.addValidate(rack);
        if(validateObject.getResult().equals("error")){
            return new ApiResponse("error",101,validateObject.getFaultmessage()).getFaultResponse();
        }
        ValidateObject datacenterValidate = this.datacenterValidate.findByIdValidate(rack.getDatacenterId().getId());
        if(datacenterValidate.getResult().equals("error")){
            return new ApiResponse("error",101,datacenterValidate.getFaultmessage()).getFaultResponse();
        }
        Datacenter datacenter = this.datacenterService.findById(rack.getDatacenterId().getId());
        rack.setDatacenterId(datacenter);
        this.rackService.add(rack);
        return new ApiResponse("success",new ArrayList(Arrays.asList(rack))).getSuccessResponse();
    }
}
