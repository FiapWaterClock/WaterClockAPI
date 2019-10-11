package br.com.waterclock.api.repository;

import br.com.waterclock.api.entity.Clock;
import br.com.waterclock.api.entity.Consumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsumptionRepository extends JpaRepository <Consumption, Integer> {
    List<Consumption> findByClockId(int clock);

    //@Query(value = "FROM Consumption c WHERE c.time BETWEEN ?1 AND ?2 GROUP BY c.time HAVING SUM(c.litersPerMinute)")
    @Query(value = "SELECT new Consumption (c.time, SUM(c.litersPerMinute)) FROM Consumption c WHERE c.clock.id = ?1 AND (c.time >= ?2 AND c.time <= ?3) GROUP BY c.time")
    List<Consumption> findByClockIdAndTimeBetween(int clock, LocalDate i, LocalDate f);

    @Query(value = "SELECT new Consumption (SUM(c.litersPerMinute)) FROM Consumption c WHERE c.clock.id = ?1 AND (c.time >= ?2 AND c.time <= ?3)")
    Consumption findSumAllTimeBetween(int clock, LocalDate i, LocalDate f);
}

