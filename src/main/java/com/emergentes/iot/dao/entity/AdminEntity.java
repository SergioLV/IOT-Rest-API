package com.emergentes.iot.dao.entity;

import com.emergentes.iot.model.Admin;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "admin")
public class AdminEntity {
    @Id
    @Column(name = "username", length = 255)
    private String username;

    @Column(name = "password", length = 255)
    private String password;

    public AdminEntity(Admin admin) {
        this.username = admin.getUsername();
        this.password = admin.getPassword();
    }

    public AdminEntity() {

    }
}
