package com.wiredav.app.repositories;

import com.wiredav.app.entities.Timeslot;
import org.springframework.data.repository.CrudRepository;

public interface TimeslotRepository extends CrudRepository<Timeslot, Long> {
}
