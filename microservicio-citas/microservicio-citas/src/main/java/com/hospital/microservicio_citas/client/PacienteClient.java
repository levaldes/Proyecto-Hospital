package com.hospital.microservicio_citas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservicio-pacientes", url = "http://localhost:8081/api/v1/pacientes")
public interface PacienteClient {
    
    @GetMapping("/{id}")
    Object buscarPorId(@PathVariable("id") Long id);
}