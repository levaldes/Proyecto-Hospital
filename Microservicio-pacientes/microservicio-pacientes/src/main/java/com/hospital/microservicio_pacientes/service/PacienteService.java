package com.hospital.microservicio_pacientes.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.microservicio_pacientes.model.Paciente;
import com.hospital.microservicio_pacientes.repository.PacienteRepository;

@Service
public class PacienteService {

    private static final Logger logger = LoggerFactory.getLogger(PacienteService.class);

    @Autowired
    private PacienteRepository repository;

    public List<Paciente> listarTodos() {
        logger.info("Consultando la lista completa de pacientes en la base de datos.");
        return repository.findAll();
    }

    public Paciente guardar(Paciente paciente) {
        logger.info("Intentando registrar un nuevo paciente con RUT: {}", paciente.getRut());
        return repository.save(paciente);
    }

    public void eliminar(Long id) {
        if (repository.existsById(id)) {
            logger.warn("Eliminando definitivamente al paciente con ID: {}", id);
            repository.deleteById(id);
        } else {
            logger.error("Error al eliminar: No se encontró el paciente con ID: {}", id);
        }
    }

    public Paciente buscarPorId(Long id) {
    return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
    }
}