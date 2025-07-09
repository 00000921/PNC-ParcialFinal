-- Crear tabla usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    correo VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    nombre_rol VARCHAR(255)
);

-- Crear tabla tickets
CREATE TABLE IF NOT EXISTS tickets (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255),
    descripcion VARCHAR(255),
    estado VARCHAR(255),
    usuario_id INTEGER REFERENCES usuarios(id),
    tecnico_asignado_id INTEGER REFERENCES usuarios(id),
    fecha TIMESTAMP
);

-- Insertar usuarios de prueba solo si no existen
INSERT INTO usuarios (nombre, correo, password, nombre_rol)
SELECT 'Usuario Prueba', 'user@test.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 'USER'
WHERE NOT EXISTS (SELECT 1 FROM usuarios WHERE correo = 'user@test.com');

INSERT INTO usuarios (nombre, correo, password, nombre_rol)
SELECT 'Técnico Prueba', 'tech@test.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 'TECH'
WHERE NOT EXISTS (SELECT 1 FROM usuarios WHERE correo = 'tech@test.com'); 