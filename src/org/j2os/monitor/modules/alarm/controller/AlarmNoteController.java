package org.j2os.monitor.modules.alarm.controller;

import org.j2os.monitor.modules.alarm.controller.validate.AlarmNoteValidate;
import org.j2os.monitor.modules.alarm.model.entity.AlarmNote;
import org.j2os.monitor.modules.alarm.model.service.AlarmNoteService;
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
@RequestMapping("/monitor/alarmnote/")

public class AlarmNoteController implements ControllerInterface {
    private AlarmNoteService alarmNoteService;
    private AlarmNoteValidate alarmNoteValidate;

    @Autowired
    public AlarmNoteController(AlarmNoteService alarmNoteService, AlarmNoteValidate alarmNoteValidate) {
        this.alarmNoteService = alarmNoteService;
        this.alarmNoteValidate = alarmNoteValidate;
    }


    @RequestMapping(method = RequestMethod.POST)
    public Object saveLog(@ModelAttribute AlarmNote alarmNote){
        ValidateObject validateObject = alarmNoteValidate.addValidate(alarmNote);
        if(validateObject.getResult().equals("success")){
            this.alarmNoteService.add(alarmNote);
            return alarmNote;
        }else{
            return "error";
        }
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
    public Object updateLog(@ModelAttribute AlarmNote alarmNote, @PathVariable("id") long id){
        ValidateObject validateObject = alarmNoteValidate.updateValidate(alarmNote);
        if(validateObject.getResult().equals("success")){
            try {
                this.alarmNoteService.update(alarmNote);
                return alarmNote;
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
        AlarmNote alarmNote = this.alarmNoteService.findById(id);
        ValidateObject validateObject = alarmNoteValidate.deleteValidate(alarmNote);
        if(validateObject.getResult().equals("success")){
            return this.alarmNoteService.delete(alarmNote);
        }else{
            return "error";
        }
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Object findOne( @PathVariable("id") long id){
        ValidateObject validateObject = alarmNoteValidate.findByIdValidate(id);
        if(validateObject.getResult().equals("success")){
            return this.alarmNoteService.findById(id);
        }else{
            return "error";
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object findOne(){
        ValidateObject validateObject = alarmNoteValidate.findAllValidate();
        if(validateObject.getResult().equals("success")){
            return this.alarmNoteService.findAll();
        }else{
            return "error";
        }
    }
}
