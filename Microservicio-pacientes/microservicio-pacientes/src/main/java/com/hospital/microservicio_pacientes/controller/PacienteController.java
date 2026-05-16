package com.hospital.microservicio_pacientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.microservicio_pacientes.model.Paciente;
import com.hospital.microservicio_pacientes.service.PacienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

@GetMapping("/{id}")
public ResponseEntity<?> obtenerPorId(@PathVariable("id") Long id) {
    try {
        Paciente paciente = service.buscarPorId(id); 
        return ResponseEntity.ok(paciente);
    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente no encontrado en DB");
    }
}

    @PostMapping
    public ResponseEntity<Paciente> guardar(@Valid @RequestBody Paciente paciente) {
        Paciente nuevoPaciente = service.guardar(paciente);
        return new ResponseEntity<>(nuevoPaciente, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}