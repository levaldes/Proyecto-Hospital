package com.hospital.microservicio_citas.controller;

import com.hospital.microservicio_citas.model.Cita;
import com.hospital.microservicio_citas.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/citas")
public class CitaController {

    @Autowired
    private CitaService service;

    @PostMapping
    public ResponseEntity<?> crearCita(@RequestBody Cita cita) {
        try {
            Cita nuevaCita = service.agendarCita(cita);
            return new ResponseEntity<>(nuevaCita, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Cita>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }
}