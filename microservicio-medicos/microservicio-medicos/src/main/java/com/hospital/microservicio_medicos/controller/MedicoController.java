package com.hospital.microservicio_medicos.controller;

import com.hospital.microservicio_medicos.model.Medico;
import com.hospital.microservicio_medicos.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicos")
public class MedicoController {

    @Autowired
    private MedicoService service;

    @GetMapping
    public ResponseEntity<List<Medico>> obtenerTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Medico> guardar(@Valid @RequestBody Medico medico) {
        return new ResponseEntity<>(service.guardar(medico), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}