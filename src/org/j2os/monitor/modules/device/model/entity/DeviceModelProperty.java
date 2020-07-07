package org.j2os.monitor.modules.device.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "device_model_property")
@Entity
public class DeviceModelProperty implements Serializable {
    @Id
    @SequenceGenerator(name = "deviceModelPropertySeq",sequenceName = "devicemodelproperty_seq",allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "deviceModelPropertySeq")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "device_model_id")
    private DeviceModel deviceModel;

    @Column(name = "type")
    private String type;

    @Column(name = "url")
    private String url;

    @Column(name = "tereshold")
    private Long tereshold;

    public DeviceModelProperty() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getTereshold() {
        return tereshold;
    }

    public void setTereshold(Long tereshold) {
        this.tereshold = tereshold;
    }
}
