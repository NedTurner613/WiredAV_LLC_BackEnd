package com.appointments.repository;

import com.appointments.entity.Timeslot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TimeslotRepositoryTest {

    @Autowired
    private TimeslotRepository timeslotRepository;

    @Test
    void savesAndFindsTimeslot() {
        Timeslot timeslot = new Timeslot();
        timeslot.setStartTime(LocalDateTime.of(2026, 8, 10, 9, 0));
        timeslot.setEndTime(LocalDateTime.of(2026, 8, 10, 9, 30));

        Timeslot saved = timeslotRepository.save(timeslot);

        Optional<Timeslot> found = timeslotRepository.findById(saved.getTimeslotId());
        assertThat(found).isPresent();
        assertThat(found.get().getStartTime()).isEqualTo(LocalDateTime.of(2026, 8, 10, 9, 0));
    }
}
