# CONVOCATORIA ORDINARIA FEBRERO  
**12 DE FEBRERO 2025**

**NOMBRE** : ________________________________________________________________

## FORMATO DE ENTREGA

Crea un fichero comprimido de nombre:  
**`ADFEB_NOMBREAPELLIDO.ZIP`** que contenga:

- El proyecto Eclipse y los ficheros JAR (de nombres `Ejercicio1.jar` y `Ejercicio2.jar`) para ejecutar cada ejercicio.
- Se ejecutarán los `.jar` desde la línea de comandos del DOS.
- Crear el `.jar` para cada ejercicio será necesario para obtener la nota completa.

> La versión mínima de Java para ejecutar los `.jar` será la **21**.

---

## ESTRUCTURA DEL EXAMEN

El examen se realizará en un proyecto Eclipse con Maven de nombre  
**`AD_Feb_NombreApellidos`**.

Se proporciona el archivo `pom.xml`, para aquellos que lo precisen, en el fichero `.zip` que se encuentra en la entrega en la plataforma del aula virtual.

---

## PENALIZACIONES

- ❌ Errores no manejados que puedan aparecer durante la revisión (hasta **1 punto** menos).
- ❌ Errores no manejados durante la ejecución normal (afectan a la nota final de cada ejercicio).
- ❌ Código desordenado o con nombres poco descriptivos (hasta **0.5 puntos** menos).

---

## IMPORTANTE  
🚫 **EL USO DE CHATGPT ESTÁ PROHIBIDO.**  
Si hay dudas ante la autenticidad del código, se podrá pedir al alumno que lo defienda ante la profesora.

---

## EJERCICIO 1: FICHERO SECUENCIAL DE OBJETOS (**6 PUNTOS**)

- **Archivo:** `Ejercicio1.java`

Se debe generar un fichero secuencial de objetos llamado `Hospitales.dat`, ordenado por código del hospital.  
Cada registro debe contener:

- Datos del hospital: `hospital_cod`, `nombre`, `direccion`.
- Información de las salas: `sala_cod`, `nombre`, ordenadas por `sala_cod`.
- Información de la plantilla: `empleado_no`, `apellido`, ordenados por `empleado_no`.

Este fichero se debe sobrescribir en cada ejecución.  
Se deben crear las clases necesarias para este proceso.

---

## EJERCICIO 2: LISTADO (**4 PUNTOS**)

- **Archivo:** `Ejercicio2.java`

Usando el fichero `Hospitales.dat` generado en el Ejercicio 1, se debe mostrar un listado con la siguiente estructura:

- Ordenado por hospital → por sala → por número de empleado.
- Alineación correcta de columnas.
- Mostrar mensaje si no hay salas o plantilla.

### 📄 Formato de salida esperado:
```
=============================================================
Apellidos Nombre
=============================================================
COD-HOSPITAL: 13
NOMBRE: Provincial
DIRECCIÓN: O Donell 5O
-------------------------------------------------------------
SALA NOMBRE
==== ====================
3 Cuidados Intensivos
6 Psiquiátrico
EMPLEADO_NO APELLIDO
=========== ====================
3106 Hernandez J.
3754 Diaz B.
-------------------------------------------------------------
COD-HOSPITAL: 15
NOMBRE: De Especialidades
DIRECCIÓN: Sagasta 34
-------------------------------------------------------------
SALA NOMBRE
==== ====================
3 Cuidados Intensivos
8 Obstetricia
EMPLEADO_NO
===========
1200
APELLIDO
====================
Urruti A.
1201 Sarabia A.
1203 Moreno L.
4234 Martinez M.
4400 Fernandez R.
-------------------------------------------------------------
COD-HOSPITAL: 18
NOMBRE: General
DIRECCIÓN: Atocha s/n
-------------------------------------------------------------
SALA NOMBRE
==== ====================
1 Vigilancia Salud
2 Maternidad
3 Cuidados Intensivos
4 Cardiología
EMPLEADO_NO APELLIDO
=========== ====================
6357 Karplus W.
-------------------------------------------------------------
COD-HOSPITAL: 22
NOMBRE: La Paz
DIRECCIÓN: Castellana 1000
-------------------------------------------------------------
SALA NOMBRE
==== ====================
1 Recuperación
2 Maternidad
6 Psiquiátrico
EMPLEADO_NO APELLIDO
=========== ====================
1009 Higueras D.
7379 Ramos R.
8422 Bocina G.
9901 Nuñez C.
-------------------------------------------------------------
COD-HOSPITAL: 25
NOMBRE: Nuevo Siglo I
DIRECCIÓN: Leganes 67
-------------------------------------------------------------
SALA NOMBRE
==== ====================
EL HOSPITAL NO TIENE SALAS
EMPLEADO_NO APELLIDO
=========== ====================
EL HOSPITAL NO TIENE PLANTILLA
-------------------------------------------------------------
```

---

ℹ️ **Recuerda**: si el formato no se respeta, el ejercicio se puntuará **solo con la mitad de la nota**.
