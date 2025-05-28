# Proyecto de Programación y Base de Datos

![Fondo del Proyecto](https://github.com/deperdomo/RepasoGithub/blob/main/otros/fotos/Fondo_1.png)

Este repositorio contiene un proyecto desarrollado en Java para la gestión integral de una empresa, abarcando áreas como clientes, recursos humanos, proyectos y facturación.

## Tabla de Contenidos

- [Estructura del Proyecto](#estructura-del-proyecto)
- [Módulos del Proyecto](#módulos-del-proyecto)
  - [Clientes](#clientes)
  - [Recursos Humanos](#recursos-humanos)
  - [Proyectos](#proyectos)
  - [Facturación](#facturación)
- [Guía Modular](#guía-modular)
- [Actividades a Entregar](#actividades-a-entregar)
- [Autores](#autores)

---

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes:

- **`modelo.entities`**: Contiene las entidades del modelo de datos.
- **`modelo.dao`**: Interfaces y clases DAO para el acceso a datos.
- **`test.entities`**: Pruebas relacionadas con las entidades del modelo.
- **`test.daos`**: Pruebas relacionadas con los DAOs.
- **`principales`**: Clases principales del proyecto.

---

## Módulos del Proyecto

### Clientes

Gestión de información de clientes, incluyendo:

- Alta, búsqueda, listado y eliminación de clientes.
- Implementación de CRUD mediante `ClienteDao` y `ClienteDaoImplMy8Jpa`.

### Recursos Humanos

Gestión de empleados y departamentos:

- Clases `Departamento` y `Empleado`.
- Métodos para consultas específicas como empleados por departamento, salario total, etc.

### Proyectos

Gestión de proyectos y empleados asignados:

- Consultas por estado, cliente, jefe de proyecto, entre otros.
- Cálculo de métricas relacionadas con proyectos y empleados.

### Facturación

Generación de facturas físicas para proyectos:

- Tabla `FACTURAS` y representación mediante un javabean.
- Implementación de DAO para interacción con la base de datos.
- Clase `ImprimirFactura` para formato de impresión.

---

## Guía Modular

El desarrollo del proyecto sigue una estructura modular, dividiendo las funcionalidades en distintos componentes para facilitar su mantenimiento y escalabilidad.

---

## Actividades a Entregar

Las actividades del proyecto están organizadas y marcadas en el README. Cada actividad representa un objetivo específico dentro del desarrollo.

---

## Autores

<div align="center">
    <a href="https://github.com/deperdomo">
        <img src="https://avatars.githubusercontent.com/u/148397340?s=96&v=4" width="100px" height="100px" style="border-radius: 50%;">
    </a>
    <a href="https://github.com/DiegoMartzG">
        <img src="https://avatars.githubusercontent.com/u/150907836?v=4" width="100px" height="100px" style="border-radius: 50%;">
    </a>
    <a href="https://github.com/rubenperaita">
        <img src="https://avatars.githubusercontent.com/u/72934096?v=4" width="100px" height="100px" style="border-radius: 50%;">
    </a>
</div>

---
