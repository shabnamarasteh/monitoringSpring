package org.j2os.monitor.modules.device.model.entity;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "device")
    private List<DeviceModel> deviceModel;


}
