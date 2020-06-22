package org.j2os.monitor.modules.device.model.entity;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class DeviceModel {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="device_model_seq")
    @SequenceGenerator(name="device_model_seq", sequenceName="device_model_seq", allocationSize=1)
    private long id;

    @Column(columnDefinition = "varchar2(200)")
    private String name;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    @OneToMany(mappedBy = "deviceGroup")
    private List<DeviceGroup> deviceGroups;

    @Column(columnDefinition = "number")
    private long max_unit;

    @Column(columnDefinition = "varchar2(200)")
    private String cover;


    public DeviceModel() {
    }

    public DeviceModel(String name, Device device, List<DeviceGroup> deviceGroups, long max_unit, String cover) {
        this.name = name;
        this.device = device;
        this.deviceGroups = deviceGroups;
        this.max_unit = max_unit;
        this.cover = cover;
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

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public List<DeviceGroup> getDeviceGroups() {
        return deviceGroups;
    }

    public void setDeviceGroups(List<DeviceGroup> deviceGroups) {
        this.deviceGroups = deviceGroups;
    }

    public long getMax_unit() {
        return max_unit;
    }

    public void setMax_unit(long max_unit) {
        this.max_unit = max_unit;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
