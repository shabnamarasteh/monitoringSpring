package org.j2os.monitor.modules.device.model.entity;

import javax.persistence.*;
import java.security.acl.Owner;
import java.util.List;

@Entity
@Table
public class Device {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="device_seq")
    @SequenceGenerator(name="device_seq", sequenceName="device_seq", allocationSize=1)
    private long id;

    @Column(columnDefinition = "varchar2(200)")
    private String name;

    @Column(columnDefinition = "varchar2(30)")
    private String ip_address;

    @ManyToOne
    @JoinColumn(name = "device_model_id")
    private DeviceModel deviceModelId;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner ownerId;

    @ManyToOne
    @JoinColumn(name = "rack_id")
    private Rack rackId;

    @Column(name = "start_unit", columnDefinition = "number")
    private long start_unit;

    public Device() {
    }

    public Device(String name, String ip_address, DeviceModel deviceModelId, Owner ownerId, Rack rackId, long start_unit) {
        this.name = name;
        this.ip_address = ip_address;
        this.deviceModelId = deviceModelId;
        this.ownerId = ownerId;
        this.rackId = rackId;
        this.start_unit = start_unit;
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

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public DeviceModel getDeviceModelId() {
        return deviceModelId;
    }

    public void setDeviceModelId(DeviceModel deviceModelId) {
        this.deviceModelId = deviceModelId;
    }

    public Owner getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Owner ownerId) {
        this.ownerId = ownerId;
    }

    public Rack getRackId() {
        return rackId;
    }

    public void setRackId(Rack rackId) {
        this.rackId = rackId;
    }

    public long getStart_unit() {
        return start_unit;
    }

    public void setStart_unit(long start_unit) {
        this.start_unit = start_unit;
    }
}
