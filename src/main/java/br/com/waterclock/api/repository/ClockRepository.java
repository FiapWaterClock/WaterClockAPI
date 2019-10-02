package br.com.waterclock.api.repository;

import br.com.waterclock.api.entity.Clock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClockRepository  extends JpaRepository <Clock, Integer> {

    public Clock findById(int id);
}
