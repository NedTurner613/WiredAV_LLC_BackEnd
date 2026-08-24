package com.wiredav.app.repositories;

import com.wiredav.app.entities.Clients;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientsRepository extends CrudRepository<Clients, Long> {

    Optional<Clients> findByEmailAddress(String email);

}
