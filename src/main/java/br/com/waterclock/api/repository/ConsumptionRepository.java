package br.com.waterclock.api.repository;

import br.com.waterclock.api.entity.Clock;
import br.com.waterclock.api.entity.Consumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsumptionRepository extends JpaRepository <Consumption, Integer> {
    List<Consumption> findByClockId(int clock);

    List<Consumption> findByClockIdAndTimeBetween(int clock, LocalDate i, LocalDate f);
}

