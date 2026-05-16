package com.hospital.microservicio_citas.service;

import com.hospital.microservicio_citas.model.Cita;
import com.hospital.microservicio_citas.repository.CitaRepository;
import com.hospital.microservicio_citas.client.PacienteClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {

    private static final Logger logger = LoggerFactory.getLogger(CitaService.class);

    @Autowired
    private CitaRepository repository;

    @Autowired
    private PacienteClient pacienteClient;

    public Cita agendarCita(Cita cita) {
        logger.info("Iniciando validación remota para el paciente con ID: {}", cita.getPacienteId());
        try {
            pacienteClient.buscarPorId(cita.getPacienteId());
            logger.info("Paciente verificado con éxito. Guardando cita en 'db_citas'.");
            return repository.save(cita);
        } catch (Exception e) {
            logger.error("Error crítico: El paciente con ID {} no existe en el sistema.", cita.getPacienteId());
            throw new RuntimeException("No se puede agendar: Paciente no encontrado");
        }
    }

    public List<Cita> listarTodas() {
        logger.info("Obteniendo el historial completo de citas.");
        return repository.findAll();
    }
}