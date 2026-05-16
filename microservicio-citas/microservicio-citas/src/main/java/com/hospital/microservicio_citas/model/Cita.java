package com.hospital.microservicio_citas.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaHora;
    private Long pacienteId;
    private Long medicoId;
    private String observacion;

    public Cita() {}

    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }

    public LocalDateTime getFechaHora() { 
        return fechaHora; 
    }
    public void setFechaHora(LocalDateTime fechaHora) { 
        this.fechaHora = fechaHora; 
    }

    public Long getPacienteId() { 
        return pacienteId; 
    }
    public void setPacienteId(Long pacienteId) { 
        this.pacienteId = pacienteId; 
    }

    public Long getMedicoId() { 
        return medicoId; 
    }
    public void setMedicoId(Long medicoId) { 
        this.medicoId = medicoId; 
    }

    public String getObservacion() { 
        return observacion; 
    }
    public void setObservacion(String observacion) { 
        this.observacion = observacion; 
    }
}