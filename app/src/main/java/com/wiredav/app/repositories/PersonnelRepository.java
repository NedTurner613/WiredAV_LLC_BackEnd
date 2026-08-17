package com.wiredav.app.repositories;

import com.wiredav.app.entities.Personnel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface PersonnelRepository extends CrudRepository<Personnel, Long> {
}
