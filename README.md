Proyecto Biblioteca Universitaria


Descripción

Este proyecto es un backend desarrollado con Spring Boot para la gestión de bibliotecas universitarias. Permite registrar libros, usuarios, préstamos y devoluciones, conectándose a una base de datos relacional mediante JPA/Hibernate y protegiendo las rutas con autenticación JWT y roles (ADMIN, USUARIO).

 Estructura del Proyecto

src/main/java/com/proyecto/biblioteca/
 ├── model/
 │    ├── Usuario.java
 │    ├── Rol.java
 │    ├── Libro.java
 │    └── Prestamo.java
 ├── repository/
 │    ├── UsuarioRepository.java
 │    ├── RolRepository.java
 │    ├── LibroRepository.java
 │    └── PrestamoRepository.java
 ├── service/
 │    ├── UsuarioService.java
 │    ├── LibroService.java
 │    └── PrestamoService.java
 ├── controller/
 │    ├── AuthController.java
 │    ├── LibroController.java
 │    └── PrestamoController.java
 └── security/
      ├── JwtUtil.java
      ├── JwtFilter.java
      └── SecurityConfig.java
Instalación

Clonar el repositorio.

Configurar application.properties con tu base de datos:

spring.datasource.url=jdbc:postgresql://localhost:5432/biblioteca
spring.datasource.username=postgres
spring.datasource.password=tu_clave
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=false

Ejecutar el proyecto con Maven:

mvn spring-boot:run

 Seguridad

Autenticación con JWT.

Roles: ADMIN, USUARIO.

Header requerido en Postman:

Authorization: Bearer <token>

📌 Endpoints principales

Autenticación

POST /api/auth/register → Registrar usuario (rol USUARIO por defecto).

POST /api/auth/login → Login y obtener token JWT.

Libros

POST /api/libros/guardar → Guardar libro (ADMIN).

GET /api/libros/listar → Listar libros (ADMIN/USUARIO).

Préstamos

POST /api/prestamos/registrar → Registrar préstamo (ADMIN).

GET /api/prestamos/historial/{usuarioId} → Historial de préstamos (USUARIO).

 Pruebas

Se recomienda usar Postman para probar los endpoints.

Ejemplo de login:

{
  "correo": "usuario@test.com",
  "password": "12345"
}

Ejemplo de header:

Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...

 Documentación

Integrado con Swagger/OpenAPI.

Acceso en: http://localhost:8080/swagger-ui.html

 Informe Técnico

El informe debe incluir:

Descripción del sistema.

Diagrama de entidades (Usuario–Rol–Libro–Prestamo).

Evidencias de pruebas (capturas de Postman).

Enlace al repositorio GitHub.

 Conclusión

Este proyecto cumple con la rúbrica: persistencia con JPA/Hibernate, seguridad JWT, control de acceso por roles, validaciones, manejo de errores y documentación con Swagger/Postman.
