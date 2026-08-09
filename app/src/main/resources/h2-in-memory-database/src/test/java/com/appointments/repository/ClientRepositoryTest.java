package com.appointments.repository;

import com.appointments.entity.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void savesAndFindsClient() {
        Client client = new Client();
        client.setFirstName("Ada");
        client.setLastName("Lovelace");
        client.setPhoneNumber("555-0100");
        client.setEmailAddress("ada@example.com");

        Client saved = clientRepository.save(client);

        Optional<Client> found = clientRepository.findById(saved.getClientId());
        assertThat(found).isPresent();
        assertThat(found.get().getFirstName()).isEqualTo("Ada");
        assertThat(found.get().getEmailAddress()).isEqualTo("ada@example.com");
    }
}
