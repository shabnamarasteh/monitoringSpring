package org.j2os.monitor.modules.common.model.entity;

import java.util.List;

public class ValidateObject {
    private List data;
    private String result;
    private String faultmessage;
    private String faultCode;

    public ValidateObject(List data, String result, String faultmessage, String faultCode) {
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

    public ValidateObject(String result, String faultmessage, String faultCode) {
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

    public String getFaultmessage() {
        return faultmessage;
    }

    public void setFaultmessage(String faultmessage) {
        this.faultmessage = faultmessage;
    }

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode;
    }
}
