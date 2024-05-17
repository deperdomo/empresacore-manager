CREATE DATABASE clientes_proyectos_empleados_IFP_2024;
USE clientes_proyectos_empleados_IFP_2024;

CREATE TABLE clientes (
    cif VARCHAR(10) NOT NULL PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    apellidos VARCHAR(45) NOT NULL,
    domicilio VARCHAR(100),
    facturacion_anual DECIMAL(15,2),
    numero_empleados INT
);

INSERT INTO clientes (cif, nombre, apellidos, domicilio, facturacion_anual, numero_empleados) 
VALUES 
    ('A22222222', 'Carlos', 'March', 'Madrid', 12000000, 1500),
    ('B33333333', 'Sara', 'Varas', 'Sevilla', 1500000, 345),
    ('C44444444', 'Ana', 'Garcia', 'Barcelona', 2500000, 200),
    ('D55555555', 'Luis', 'Fernandez', 'Valencia', 5000000, 500);

CREATE TABLE departamentos (
    id_depar INT PRIMARY KEY,
    nombre VARCHAR(45) NOT NULL,
    direccion VARCHAR(100)
);

INSERT INTO departamentos 
VALUES
    (10, 'Gestion Personas', 'Madrid'),
    (20, 'Software', 'Madrid'),
    (30, 'Hardware', 'Madrid'),
    (40, 'Financiero', 'Sevilla'),
    (50, 'Marketing', 'Barcelona');

CREATE TABLE perfiles (
    id_perfil INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20),
    tasa_standard DECIMAL(7,2)
);

INSERT INTO perfiles (nombre, tasa_standard)
VALUES 
    ('Control de Gestion', 120),
    ('Jefe de Proyecto', 220),
    ('Operativo', 100),
    ('Recursos Humanos', 250),
    ('Marketing', 200);

CREATE TABLE empleados (
    id_empl INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    apellidos VARCHAR(45) NOT NULL,
    genero CHAR(1) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(45) NOT NULL,
    salario DECIMAL(9,2),
    fecha_ingreso DATE,
    fecha_nacimiento DATE,
    id_perfil INT NOT NULL,
    id_depar INT NOT NULL,
    CHECK(genero IN('H', 'h', 'M', 'm')),
    FOREIGN KEY(id_depar) REFERENCES departamentos(id_depar),
    FOREIGN KEY(id_perfil) REFERENCES perfiles(id_perfil)
);

INSERT INTO empleados 
    (nombre, apellidos, genero, email, password, salario, fecha_ingreso, fecha_nacimiento, id_perfil, id_depar) 
VALUES 
    ('Esteban', 'Diaz', 'H', 'ediaz@tt.com', 'esteban', 90000, '1990-01-12', '1977-02-12', 4, 10),
    ('Sara', 'Hernandez', 'M', 'shernandez@tt.com', 'sara', 45000, '2005-07-07', '1987-05-15', 4, 10),
    ('Rafael', 'Raphaelly', 'H', 'rraphaelly@tt.com', 'rafael', 78000, '2005-09-07', '1977-02-18', 2, 20),
    ('Carlos', 'Koo', 'H', 'ckoo@tt.com', 'carlos', 33000, '2015-09-07', '1983-02-04', 3, 20),
    ('Carmen', 'Baida', 'M', 'cbaida@tt.com', 'carmen', 32000, '2015-09-08', '1983-12-04', 3, 20),
    ('Alejandro', 'Himuro', 'H', 'ahimuro@tt.com', 'alejandro', 25000, '2015-09-09', '1984-12-04', 3, 20),
    ('Eva', 'Colmenares', 'M', 'ecolmenares@tt.com', 'eva', 25000, '2015-09-09', '1984-12-04', 3, 20),
    ('Eva', 'Tobias', 'M', 'etobias@tt.com', 'eva', 25000, '2015-09-09', '1984-12-04', 3, 20),
    ('Raquel', 'Oliva', 'M', 'roliva@tt.com', 'raquel', 38000, '2015-09-09', '1982-04-21', 1, 40),
    ('Laura', 'Martinez', 'M', 'lmartinez@tt.com', 'laura', 47000, '2019-03-15', '1990-06-20', 5, 50),
    ('Pedro', 'Lopez', 'H', 'plopez@tt.com', 'pedro', 51000, '2018-11-05', '1985-10-15', 1, 50);

CREATE TABLE proyectos (
    id_proyecto VARCHAR(10) NOT NULL PRIMARY KEY,
    descripcion VARCHAR(45) NOT NULL,
    fecha_inicio DATE,
    fecha_fin_previsto DATE,
    fecha_fin_real DATE,
    venta_previsto DECIMAL(11,2),
    costes_previsto DECIMAL(11,2),
    coste_real DECIMAL(11,2),
    estado VARCHAR(15),
    jefe_proyecto INT,
    cif VARCHAR(10) NOT NULL,
    CHECK(estado IN('ACTIVO', 'TERMINADO')),
    FOREIGN KEY(cif) REFERENCES clientes(cif),
    FOREIGN KEY(jefe_proyecto) REFERENCES empleados(id_empl)
);

INSERT INTO proyectos (id_proyecto, descripcion, fecha_inicio, fecha_fin_previsto, fecha_fin_real, venta_previsto, costes_previsto, coste_real, estado, jefe_proyecto, cif) 
VALUES 
    ('FOR2020001', 'Formacion de habilidades directivas', '2020-01-15', '2020-07-31', '2020-07-31', 50000, 30000, 31500, 'TERMINADO', 1, 'A22222222'),
    ('FOR2021001', 'Formacion de jefes de proyecto', '2021-09-15', '2021-12-31', NULL, 50000, 30000, NULL, 'ACTIVO', 1, 'A22222222'),
    ('FOR2021002', 'Formacion de jefes de proyecto', '2021-09-15', '2021-12-31', NULL, 50000, 30000, NULL, 'ACTIVO', 1, 'A22222222'),
    ('DEV2022001', 'Desarrollo de software', '2022-03-01', '2022-09-30', NULL, 120000, 80000, NULL, 'ACTIVO', 3, 'B33333333'),
    ('MKT2023001', 'Campaña de Marketing', '2023-01-10', '2023-06-30', NULL, 70000, 40000, NULL, 'ACTIVO', 4, 'C44444444');

CREATE TABLE proyecto_con_empleados (
    numero_orden INT AUTO_INCREMENT PRIMARY KEY,
    id_proyecto VARCHAR(10) NOT NULL,
    id_empl INT NOT NULL,
    horas_asignadas INT NOT NULL,
    fecha_incorporacion DATE,
    FOREIGN KEY(id_proyecto) REFERENCES proyectos(id_proyecto),
    FOREIGN KEY(id_empl) REFERENCES empleados(id_empl)
);

INSERT INTO proyecto_con_empleados (id_proyecto, id_empl, horas_asignadas, fecha_incorporacion) 
VALUES 
    ('FOR2020001', 2, 45, '2020-01-16'),
    ('FOR2020001', 3, 30, '2020-01-17'),
    ('FOR2021001', 4, 54, '2021-10-11'),
    ('FOR2021001', 5, 100, '2021-10-14'),
    ('DEV2022001', 1, 200, '2022-03-01'),
    ('DEV2022001', 9, 150, '2022-04-15'),
    ('MKT2023001', 10, 75, '2023-01-12'),
    ('MKT2023001', 4, 100, '2023-02-10');

CREATE TABLE familias (
    id_familia INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(45) NOT NULL
);

INSERT INTO familias (descripcion) 
VALUES 
    ('Licencias'),
    ('Hardware'),
    ('Salas'),
    ('Software'),
    ('Servicios');

CREATE TABLE productos (
    id_producto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(45) NOT NULL,
    precio DECIMAL(7,2),
    stock INT,
    fecha_creacion DATE,
    id_familia INT NOT NULL,
    FOREIGN KEY(id_familia) REFERENCES familias(id_familia)
);

INSERT INTO productos (descripcion, precio, fecha_creacion, stock, id_familia) 
VALUES 
    ('Impresora laser brother 550-DS', 125, '2018-12-05', 50, 2),
    ('Licencia Office 365', 99, '2019-03-10', 200, 1),
    ('Sala de conferencias A', 500, '2017-06-20', 10, 3),
    ('Software de Gestion', 300, '2020-01-15', 75, 4),
    ('Servicio de soporte tecnico', 150, '2021-11-10', 100, 5);

CREATE TABLE proyecto_con_productos (
    num_orden INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_proyecto VARCHAR(10) NOT NULL,
    id_producto INT NOT NULL,
    precio_asignado DECIMAL(7,2) NOT NULL,
    cantidad INT,
    FOREIGN KEY(id_proyecto) REFERENCES proyectos(id_proyecto),
    FOREIGN KEY(id_producto) REFERENCES productos(id_producto)
);

INSERT INTO proyecto_con_productos (id_proyecto, id_producto, precio_asignado, cantidad) 
VALUES 
    ('FOR2020001', 1, 100, 10),
    ('FOR2020001', 2, 99, 20),
    ('DEV2022001', 3, 500, 5),
    ('MKT2023001', 4, 300, 15);

CREATE TABLE facturas (
    id_factura VARCHAR(15) NOT NULL PRIMARY KEY,
    descripcion VARCHAR(45) NOT NULL,
    fecha_factura DATE,
    id_proyecto VARCHAR(10) NOT NULL,
    FOREIGN KEY(id_proyecto) REFERENCES proyectos(id_proyecto)
);

INSERT INTO facturas (id_factura, descripcion, fecha_factura, id_proyecto) 
VALUES 
    ('F2020001', 'Formacion a cliente 1', '2023-01-12', 'FOR2020001'),
    ('F2021001', 'Proyecto desarrollo software', '2023-04-05', 'DEV2022001'),
    ('F2023001', 'Campaña de Marketing', '2023-07-15', 'MKT2023001');

CREATE USER 'uproyectos_IFP_2024' IDENTIFIED BY 'uproyectos';
GRANT ALL PRIVILEGES ON clientes_proyectos_empleados_IFP_2024.* TO 'uproyectos_IFP_2024';
