CREATE DATABASE sis_venta;
USE sis_venta;

-- Tabla permisos (debe crearse antes que detalle_permisos)
CREATE TABLE permisos (
    id_permiso INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(100) NOT NULL
);

-- Tabla cliente
CREATE TABLE cliente (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(150),
    telefono VARCHAR(20),
    email VARCHAR(100)
);

-- Tabla configuracion
CREATE TABLE configuracion (
    id_configuracion INT PRIMARY KEY AUTO_INCREMENT,
    clave VARCHAR(100) NOT NULL,
    valor VARCHAR(100) NOT NULL
);

-- Tabla usuario (debe crearse antes que detalle_permisos)
CREATE TABLE usuario (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    password VARCHAR(100),
    rol VARCHAR(50)
);

-- Tabla detalle_permisos (ahora se puede crear sin problemas)
CREATE TABLE detalle_permisos (
    id_detalle_permiso INT PRIMARY KEY AUTO_INCREMENT,
    id_permiso INT,
    id_usuario INT,
    FOREIGN KEY (id_permiso) REFERENCES permisos(id_permiso),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

-- Tabla producto
CREATE TABLE producto (
    id_producto INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2),
    stock INT
);

-- Tabla detalle_temp
CREATE TABLE detalle_temp (
    id_detalle_temp INT PRIMARY KEY AUTO_INCREMENT,
    id_producto INT,
    cantidad INT,
    precio DECIMAL(10, 2),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

-- Tabla ventas
CREATE TABLE ventas (
    id_venta INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10, 2),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

-- Tabla detalle_venta
CREATE TABLE detalle_venta (
    id_detalle_venta INT PRIMARY KEY AUTO_INCREMENT,
    id_venta INT,
    id_producto INT,
    cantidad INT,
    precio DECIMAL(10, 2),
    FOREIGN KEY (id_venta) REFERENCES ventas(id_venta),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);
