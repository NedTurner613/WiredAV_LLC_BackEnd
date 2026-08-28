package com.wiredav.app.repositories;

import com.wiredav.app.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientsRepository extends JpaRepository<Clients, Long> {

    Optional<Clients> findByEmailAddress(String email);

}
