package com.appointments.repository;

import com.appointments.entity.Personnel;
import com.appointments.entity.PersonnelRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PersonnelRepositoryTest {

    @Autowired
    private PersonnelRepository personnelRepository;

    @Autowired
    private PersonnelRoleRepository personnelRoleRepository;

    @Test
    void savesAndFindsPersonnel() {
        PersonnelRole adminRole = new PersonnelRole();
        adminRole.setPersonnelRole("ADMIN");
        adminRole = personnelRoleRepository.save(adminRole);

        Personnel personnel = new Personnel();
        personnel.setFirstName("Grace");
        personnel.setLastName("Hopper");
        personnel.setRole(adminRole);
        personnel.setPersonnelEmail("grace@example.com");
        personnel.setPassword("hashed-password");

        Personnel saved = personnelRepository.save(personnel);

        Optional<Personnel> found = personnelRepository.findById(saved.getPersonnelId());
        assertThat(found).isPresent();
        assertThat(found.get().getRole().getPersonnelRoleId()).isEqualTo(adminRole.getPersonnelRoleId());
        assertThat(found.get().getRole().getPersonnelRole()).isEqualTo("ADMIN");
    }
}
