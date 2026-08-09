package com.appointments.repository;

import com.appointments.entity.Personnel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PersonnelRepositoryTest {

    @Autowired
    private PersonnelRepository personnelRepository;

    @Test
    void savesAndFindsPersonnel() {
        Personnel personnel = new Personnel();
        personnel.setFirstName("Grace");
        personnel.setLastName("Hopper");
        personnel.setRole("ADMIN");
        personnel.setPersonnelEmail("grace@example.com");
        personnel.setPassword("hashed-password");

        Personnel saved = personnelRepository.save(personnel);

        Optional<Personnel> found = personnelRepository.findById(saved.getPersonnelId());
        assertThat(found).isPresent();
        assertThat(found.get().getRole()).isEqualTo("ADMIN");
    }
}
