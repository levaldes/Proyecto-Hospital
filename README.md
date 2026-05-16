# Sistema de Gestión Hospitalaria - Arquitectura de Microservicios

Este proyecto consiste en un sistema de gestión de citas médicas estructurado bajo una arquitectura de microservicios utilizando **Spring Boot** y **Spring Cloud (OpenFeign)**. El ecosistema está compuesto por tres servicios independientes que se comunican de forma síncrona a través de la red y persisten sus datos en bases de datos relacionales independientes.

## 👥 Integrantes del Equipo
* Leonardo Valdes
* Daniel Jimenez
* Marcela Zepulveda

**Número de Equipo:** Equipo N° [Número de tu equipo]  
**Asignatura:** Desarrollo FullStack

---

## 🛠️ Funcionalidades Implementadas

El sistema implementa un modelo de diseño robusto para las siguientes operaciones esenciales:

1. **Microservicio de Pacientes (Puerto 8081):**
   * CRUD básico para el registro de pacientes.
   * Endpoints de consulta por ID y listado general.
   * Validación de campos obligatorios mediante anotaciones de Spring.

2. **Microservicio de Médicos (Puerto 8082):**
   * Registro y control del personal médico y sus especialidades.

3. **Microservicio de Citas (Puerto 8083 - Servicio Integrado):**
   * Orquestación de agendas médicas.
   * **Integración mediante OpenFeign:** Antes de persistir una cita, el servicio consume la API del microservicio de pacientes de forma remota para validar su existencia en tiempo real.
   * **Control de Excepciones y Robustez:** Bloqueo de transacciones y retorno de códigos de estado HTTP `400 Bad Request` ante inconsistencias de datos (ej: paciente inexistente).
   * **Trazabilidad:** Implementación de logs explícitos en consola (`Slf4j` / `Logger`) tanto para flujos exitosos como para el manejo de errores.

---

## 📋 Requisitos Previos

Para ejecutar este proyecto de manera local, asegúrate de contar con las siguientes herramientas instaladas:
* **Java JDK 17**
* **Apache Maven 3.x**
* **Laragon** (o cualquier entorno local con MySQL)
* **Thunder Client** o Postman (para pruebas de API)

---

## 🚀 Pasos para la Ejecución e Instalación

### 1. Configuración de la Base de Datos (Laragon)
Abra su gestor de bases de datos (HeidiSQL) y cree tres bases de datos independientes y vacías. El sistema se encargará de generar las tablas automáticamente (`ddl-auto=update`):
* `db_pacientes`
* `db_medicos`
* `db_citas`

### 2. Ejecución de los Microservicios
Abra una terminal independiente en VS Code para cada proyecto y ejecútelos en el siguiente orden:

```bash
# 1. Iniciar Microservicio de Pacientes (Puerto 8081)
cd microservicio-pacientes
mvn spring-boot:run

# 2. Iniciar Microservicio de Médicos (Puerto 8082)
cd microservicio-medicos
mvn spring-boot:run

# 3. Iniciar Microservicio de Citas (Puerto 8083)
cd microservicio-citas
mvn spring-boot:run
