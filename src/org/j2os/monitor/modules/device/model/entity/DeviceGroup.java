package org.j2os.monitor.modules.device.model.entity;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class DeviceGroup {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="device_model_seq")
    @SequenceGenerator(name="device_model_seq", sequenceName="device_model_seq", allocationSize=1)
    private long id;

    @Column(columnDefinition = "varchar2(200)")
    private String name;

//    @JsonIgnore
    @ManyToOne
    private DeviceModel deviceModel;

    public DeviceGroup() {
    }

    public DeviceGroup(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeviceModel getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(DeviceModel deviceModel) {
        this.deviceModel = deviceModel;
    }
}
