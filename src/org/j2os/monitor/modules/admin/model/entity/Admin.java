package org.j2os.monitor.modules.admin.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Admin {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="admin_seq")
    @SequenceGenerator(name="admin_seq", sequenceName="admin_seq", allocationSize=1)
    private long id;
    @Column(columnDefinition = "varchar2(200)")
    private String firstname;
    @Column(columnDefinition = "varchar2(200)")
    private String lastname;
    @Column(columnDefinition = "varchar2(200)")
    private String email;

    @Column(columnDefinition = "varchar2(200)")
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "creation_at" , updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role_id;

    public Admin() {
    }

    public Admin(String firstname, String lastname, String email, LocalDateTime createdAt, LocalDateTime updatedAt, Role role_id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.role_id = role_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Role getRole_id() {
        return role_id;
    }

    public void setRole_id(Role role_id) {
        this.role_id = role_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
