package org.j2os.monitor.modules.device.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "device_property")
@Entity
public class DeviceProperty implements Serializable {
    @Id
    @SequenceGenerator(name = "devicPropertySeq",sequenceName = "deviceproperty_seq",allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "devicPropertySeq")
    private Long id;

    @OneToOne
    @JoinColumn(name = "device_model_property_id")
    private DeviceModelProperty deviceModelProperty;

    @OneToOne
    @JoinColumn(name = "device_id")
    private Device device;

    private Double value;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    public DeviceProperty() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeviceModelProperty getDeviceModelProperty() {
        return deviceModelProperty;
    }

    public void setDeviceModelProperty(DeviceModelProperty deviceModelProperty) {
        this.deviceModelProperty = deviceModelProperty;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
