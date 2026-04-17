
-- Crear roles
INSERT INTO rol (id, nombre_rol) VALUES (1, 'ADMIN');
INSERT INTO rol (id, nombre_rol) VALUES (2, 'USUARIO');

-- Crear usuario ADMIN
INSERT INTO usuario (id, nombre, email, password)
VALUES (1, 'Administrador', 'admin@biblioteca.com', 'admin123');

-- Asignar rol ADMIN al usuario
INSERT INTO usuario_roles (usuario_id, rol_id) VALUES (1, 1);

-- Crear usuario normal
INSERT INTO usuario (id, nombre, email, password)
VALUES (2, 'UsuarioPrueba', 'usuario@biblioteca.com', 'usuario123');

-- Asignar rol USUARIO
INSERT INTO usuario_roles (usuario_id, rol_id) VALUES (2, 2);

-- Insertar libros de prueba
INSERT INTO libro (id, titulo, autor, editorial, disponible)
VALUES (1, 'El Quijote', 'Miguel de Cervantes', 'Clásicos', true);

INSERT INTO libro (id, titulo, autor, editorial, disponible)
VALUES (2, 'Cien Años de Soledad', 'Gabriel García Márquez', 'Sudamericana', true);

INSERT INTO libro (id, titulo, autor, editorial, disponible)
VALUES (3, 'La Ciudad y los Perros', 'Mario Vargas Llosa', 'Seix Barral', true);
SELECT * FROM usuario WHERE id = 1;

SELECT conname, confrelid::regclass AS referenced_table
FROM pg_constraint
WHERE conrelid = 'prestamo'::regclass;

-- Tabla Usuario
CREATE TABLE usuario (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Tabla Rol
CREATE TABLE rol (
    id BIGSERIAL PRIMARY KEY,
    nombre_rol VARCHAR(50) UNIQUE NOT NULL
);

-- Tabla intermedia Usuario_Roles
CREATE TABLE usuario_roles (
    usuario_id BIGINT NOT NULL,
    rol_id BIGINT NOT NULL,
    PRIMARY KEY (usuario_id, rol_id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (rol_id) REFERENCES rol(id) ON DELETE CASCADE
);

-- Tabla Libro
CREATE TABLE libro (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    editorial VARCHAR(255),
    disponible BOOLEAN NOT NULL DEFAULT TRUE
);

-- Tabla Prestamo
CREATE TABLE prestamo (
    id BIGSERIAL PRIMARY KEY,
    fecha_prestamo DATE NOT NULL,
    fecha_devolucion DATE,
    devuelto BOOLEAN NOT NULL DEFAULT FALSE,
    usuario_id BIGINT NOT NULL,
    libro_id BIGINT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (libro_id) REFERENCES libro(id) ON DELETE CASCADE
);

