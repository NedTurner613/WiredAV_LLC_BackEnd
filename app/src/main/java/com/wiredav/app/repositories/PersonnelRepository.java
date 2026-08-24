package com.wiredav.app.repositories;

import com.wiredav.app.entities.Personnel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

//@Repository
public interface PersonnelRepository extends CrudRepository<Personnel, Long> {

    Optional<Set<Personnel>> findAllByRole(Integer role);
}
