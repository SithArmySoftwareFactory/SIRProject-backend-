package com.sith.sir;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IncidentRepository extends JpaRepository<Incident, Long> {

    Incident findIncidentById(Long id);

//    List<Incident> findByNameStartingWithIgnoreCaseOrderByNameDesc(String filter);
//
//    List<Incident> findByNameStartingWithIgnoreCaseOrderByNameAsc(String filter);

    List<Incident> findAllByOrderByIdDesc();
}
