package com.hospital.microservicio_medicos.service;

import com.hospital.microservicio_medicos.model.Medico;
import com.hospital.microservicio_medicos.repository.MedicoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private static final Logger logger = LoggerFactory.getLogger(MedicoService.class);

    @Autowired
    private MedicoRepository repository;

    public List<Medico> listarTodos() {
        logger.info("Obteniendo lista de todos los médicos.");
        return repository.findAll();
    }

    public Medico guardar(Medico medico) {
        logger.info("Registrando nuevo médico: {} - Especialidad: {}", medico.getNombre(), medico.getEspecialidad());
        return repository.save(medico);
    }

    public void eliminar(Long id) {
        if (repository.existsById(id)) {
            logger.warn("Eliminando médico con ID: {}", id);
            repository.deleteById(id);
        } else {
            logger.error("No se encontró el médico con ID: {} para eliminar", id);
        }
    }
}