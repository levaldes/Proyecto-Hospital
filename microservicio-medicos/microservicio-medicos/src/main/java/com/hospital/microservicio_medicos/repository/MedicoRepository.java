package com.hospital.microservicio_medicos.repository;

import com.hospital.microservicio_medicos.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

}