package org.j2os.monitor.modules.alarm.controller;

import org.j2os.monitor.modules.alarm.controller.validate.AlarmLogValidate;
import org.j2os.monitor.modules.alarm.model.entity.AlarmLog;
import org.j2os.monitor.modules.alarm.model.service.AlarmLogService;
import org.j2os.monitor.modules.common.model.entity.ValidateObject;
import org.j2os.monitor.utils.Interfaces.controller.ControllerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping("/monitor/alarmlog/")
public class AlarmLogController implements ControllerInterface {
    private AlarmLogService alarmLogService;
    private AlarmLogValidate alarmLogValidate;

    @Autowired
    public AlarmLogController(AlarmLogService alarmLogService,AlarmLogValidate alarmLogValidate) {
        this.alarmLogService = alarmLogService;
        this.alarmLogValidate = alarmLogValidate;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object saveLog(@ModelAttribute AlarmLog alarmLog){
        ValidateObject validateObject = alarmLogValidate.addValidate(alarmLog);
        if(validateObject.getResult().equals("success")){
            this.alarmLogService.add(alarmLog);
            return alarmLog;
        }else{
            return "error";
        }
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
    public Object updateLog(@ModelAttribute AlarmLog alarmLog, @PathVariable("id") long id){
        ValidateObject validateObject = alarmLogValidate.updateValidate(alarmLog);
        if(validateObject.getResult().equals("success")){
            try {
                this.alarmLogService.update(alarmLog);
                return alarmLog;
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                return "error";
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return "error";
            }
        }else{
            return "error";
        }
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public Object deleteLog( @PathVariable("id") long id){
        AlarmLog alarmLog = this.alarmLogService.findById(id);
        ValidateObject validateObject = alarmLogValidate.deleteValidate(alarmLog);
        if(validateObject.getResult().equals("success")){
           return this.alarmLogService.delete(alarmLog);
        }else{
            return "error";
        }
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Object findOne( @PathVariable("id") long id){
        ValidateObject validateObject = alarmLogValidate.findByIdValidate(id);
        if(validateObject.getResult().equals("success")){
           return this.alarmLogService.findById(id);
        }else{
            return "error";
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object findOne(){
        ValidateObject validateObject = alarmLogValidate.findAllValidate();
        if(validateObject.getResult().equals("success")){
           return this.alarmLogService.findAll();
        }else{
            return "error";
        }
    }
}
