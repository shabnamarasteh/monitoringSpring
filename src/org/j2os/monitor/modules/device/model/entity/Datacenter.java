package org.j2os.monitor.modules.device.model.entity;

import org.j2os.monitor.modules.common.model.entity.City;

import javax.persistence.*;

@Entity
@Table
public class Datacenter {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="datacenter_seq")
    @SequenceGenerator(name="datacenter_seq", sequenceName="datacenter_seq", allocationSize=1)
    private long id;

    @Column(name = "name" , columnDefinition = "varchar2(200)")
    private String name;

    @Column(name = "location" , columnDefinition = "varchar2(200)")
    private String location;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City cityId;

    public Datacenter() {
    }

    public Datacenter(String name, String location, City cityId) {
        this.name = name;
        this.location = location;
        this.cityId = cityId;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }
}
