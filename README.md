# Proyecto de Programación y Base de Datos

<div style="background-image: url('https://github.com/ddpm24/RepasoGithub/blob/main/otros/fotos/Fondo_1.png'); background-size: cover; padding: 50px 0;">
    <h1 style="text-align: center; color: white;">Título del Proyecto</h1>
</div>


Este repositorio contiene un proyecto de Java relacionado con la gestión de una empresa en varias áreas, como clientes, recursos humanos, proyectos y facturación.

## Estructura de Paquetes

El proyecto está estructurado en los siguientes paquetes:

- `modelo.entities`: Contiene las entidades del modelo de datos.
- `modelo.dao`: Contiene las interfaces y clases DAO para acceder a los datos.
- `test.entities`: Contiene pruebas relacionadas con las entidades del modelo.
- `test.daos`: Contiene pruebas relacionadas con los DAOs.
- `principales`: Contiene las clases principales del proyecto.

## Módulos del Proyecto

### 1. CLIENTES

El módulo de clientes se encarga de gestionar la información relacionada con los clientes de la empresa. Incluye una clase Principal llamada "GestionClientes" con un menú que permite realizar diversas operaciones, como dar de alta un cliente, buscar un cliente, mostrar todos los clientes, eliminar un cliente y salir del programa. Además, define la interfaz ClienteDao para el CRUD de clientes y la clase ClienteDaoImplMy8Jpa que implementa dicha interfaz.

### 2. Recursos Humanos

Este módulo se encarga de gestionar la información relacionada con los empleados y departamentos de la empresa. Define las clases Departamento y Empleado, así como las interfaces y clases DAO correspondientes. También incluye métodos propios de la clase Empleado y métodos adicionales en EmpleadoDao para realizar consultas específicas, como obtener empleados por departamento, sexo o apellido, calcular el salario total, etc.

### 3. Proyectos – Empleados en Proyecto

Este módulo se encarga de gestionar la información relacionada con los proyectos de la empresa y los empleados asignados a cada proyecto. Define la clase Proyecto con métodos propios y la interfaz ProyectoDao con métodos adicionales para consultar proyectos por estado, cliente, jefe de proyecto, etc. También incluye métodos para calcular diversas métricas relacionadas con los proyectos y los empleados en proyecto.

### 4. Facturas

El módulo de facturación se encarga de generar facturas físicas para los proyectos de la empresa. Define una tabla `FACTURAS` con información relevante, así como un javabean para representar una factura. También define la interfaz FacturaDao y la clase FacturaDaoImpl para interactuar con la base de datos. Además, incluye la clase ImprimirFactura en el paquete principales para imprimir los datos de la factura según un formato específico.

## Guía Modular

El proyecto sigue una guía modular para su desarrollo, dividiendo las funcionalidades en distintos módulos y proporcionando una estructura organizada y coherente.

## Actividades a Entregar

El proyecto incluye una serie de actividades a entregar, las cuales están marcadas en la estructura del README.md. Cada actividad representa un objetivo específico a cumplir dentro del proyecto.

---



 <h2 align="center">Autores</h2>
<div align="center">
    <a href="https://github.com/ddpm24">
        <img src="https://avatars.githubusercontent.com/u/148397340?s=96&v=4" width="100px" height="100px" style="border-radius: 50%;">
    </a>
    <a href="https://github.com/DiegoMartzG">
        <img src="https://avatars.githubusercontent.com/u/150907836?v=4" width="100px" height="100px" style="border-radius: 50%;">
    </a>
    <a href="https://github.com/rubenperaita">
        <img src="https://avatars.githubusercontent.com/u/72934096?v=4" width="100px" height="100px" style="border-radius: 50%;">
    </a>
</div>


