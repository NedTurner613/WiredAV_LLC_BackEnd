package com.appointments.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personnel_roles")
public class PersonnelRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personnel_role_id")
    private Integer personnelRoleId;

    @Column(name = "personnel_role")
    private String personnelRole;

    public Integer getPersonnelRoleId() {
        return personnelRoleId;
    }

    public void setPersonnelRoleId(Integer personnelRoleId) {
        this.personnelRoleId = personnelRoleId;
    }

    public String getPersonnelRole() {
        return personnelRole;
    }

    public void setPersonnelRole(String personnelRole) {
        this.personnelRole = personnelRole;
    }
}
