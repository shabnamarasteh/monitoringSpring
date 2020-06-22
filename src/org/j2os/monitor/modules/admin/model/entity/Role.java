package org.j2os.monitor.modules.admin.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="role_seq")
    @SequenceGenerator(name="role_seq", sequenceName="role_seq", allocationSize=1)
    private long id;
    @Column(columnDefinition = "varchar2(200)")
    private String name;

    @OneToMany(mappedBy = "role_id" )
    private List<Admin> adminList;

    public Role() {
    }

    public Role(String name, List<Admin> adminList) {
        this.name = name;
        this.adminList = adminList;
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

    public List<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
    }
}
