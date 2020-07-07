package org.j2os.monitor.modules.common.model.entity;

import java.util.List;

public class ValidateObject {
    private List data;
    private String result;
    private List<String> faultmessage;
    private String faultCode;

    public ValidateObject(List data, String result, List<String> faultmessage, String faultCode) {
        this.data = data;
        this.result = result;
        this.faultmessage = faultmessage;
        this.faultCode = faultCode;
    }

    public ValidateObject() {
    }

    public ValidateObject(List data, String result) {
        this.data = data;
        this.result = result;
    }

    public ValidateObject(String result, List<String> faultmessage, String faultCode) {
        this.result = result;
        this.faultmessage = faultmessage;
        this.faultCode = faultCode;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<String> getFaultmessage() {
        return faultmessage;
    }

    public void setFaultmessage(List<String> faultmessage) {
        this.faultmessage = faultmessage;
    }

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode;
    }
}
