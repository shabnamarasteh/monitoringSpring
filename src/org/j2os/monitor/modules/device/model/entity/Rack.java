package org.j2os.monitor.modules.device.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Rack implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="rack_seq")
    @SequenceGenerator(name="rack_seq", sequenceName="rack_seq", allocationSize=1)
    private long id;

    @Column(name = "name" , columnDefinition = "varchar2(200)")
    private String name;

    @ManyToOne
    @JoinColumn(name = "datacenter_id")
    private Datacenter datacenterId;

    @Column(name = "max_unit" , columnDefinition = "number")
    private long max_unit;

    public Rack() {
    }

    public Rack(String name, Datacenter datacenterId, long max_unit) {
        this.name = name;
        this.datacenterId = datacenterId;
        this.max_unit = max_unit;
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

    public Datacenter getDatacenterId() {
        return datacenterId;
    }

    public void setDatacenterId(Datacenter datacenterId) {
        this.datacenterId = datacenterId;
    }

    public long getMax_unit() {
        return max_unit;
    }

    public void setMax_unit(long max_unit) {
        this.max_unit = max_unit;
    }
}
