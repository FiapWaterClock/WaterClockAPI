package br.com.waterclock.api.br.com.waterclock.api.repository;

import br.com.waterclock.api.br.com.waterclock.api.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {
    Privilege findByName(String name);
}
