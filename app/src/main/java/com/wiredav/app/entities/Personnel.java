package com.wiredav.app.entities;

import com.wiredav.app.enums.PersonnelRole;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "personnel")
public class Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personnelId", nullable = false)
    private long personnelId;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "role", nullable = false)
    private PersonnelRole role;

    @Column(name = "personnelEmail", nullable = false)
    private String personnelEmail;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "personnel", cascade = CascadeType.ALL)
    private Set<Appointments> appointments = new HashSet<>();

    public Personnel(String firstName, String lastName, PersonnelRole role, String personnelEmail, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.personnelEmail = personnelEmail;
        this.password = password;
    }

    public Personnel() {}

    public void setPersonnelId(long personnelId) {
        this.personnelId = personnelId;
    }

    public long getPersonnelId() {
        return personnelId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setRole(PersonnelRole role) {
        this.role = role;
    }

    public PersonnelRole getRole() {
        return role;
    }

    public void setPersonnelEmail(String personnelEmail) {
        this.personnelEmail = personnelEmail;
    }

    public String getPersonnelEmail() {
        return personnelEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setAppointments(Set<Appointments> appointments) {
        this.appointments = appointments;
    }

    public Set<Appointments> getAppointments() {
        return appointments;
    }
}
