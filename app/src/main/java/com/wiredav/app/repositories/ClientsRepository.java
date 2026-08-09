package com.wiredav.app.repositories;

import com.wiredav.app.entities.Clients;
import org.springframework.data.repository.CrudRepository;

public interface ClientsRepository extends CrudRepository<Clients, Long> {
}
