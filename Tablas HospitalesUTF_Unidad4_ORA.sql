-- Creación de las tablas

Use hospitales

-- HOSPITALES
CREATE TABLE HOSPITALES (
    HOSPITAL_COD INT(2),
    NOMBRE VARCHAR(20),
    DIRECCION VARCHAR(20),
    TELEFONO CHAR(8),
    NUM_CAMA INT(3),
    PRIMARY KEY (HOSPITAL_COD)
) ENGINE=InnoDB;

INSERT INTO HOSPITALES (HOSPITAL_COD, NOMBRE, DIRECCION, TELEFONO, NUM_CAMA) 
VALUES 
(13, 'Provincial', 'O Donell 5O', '964-4264', 502),
(15, 'De Especialidades', 'Sagasta 34', '999-8770', 300),
(18, 'General', 'Atocha s/n', '595-3111', 987),
(22, 'La Paz', 'Castellana 1000', '923-5411', 412),
(25, 'Nuevo Siglo I', 'Leganes 67', '999-8771', 100),
(26, 'Nuevo Siglo II', 'Leganes 68', '999-8772', 100),
(45, 'San Carlos', 'Ciudad Universitaria', '597-1500', 845);


-- SALA
CREATE TABLE SALA (
    HOSPITAL_COD INT(2) NOT NULL,
    SALA_COD INT(2),
    NOMBRE VARCHAR(20),
    NUM_CAMA INT(3),
    PRIMARY KEY (HOSPITAL_COD, SALA_COD),
    FOREIGN KEY (HOSPITAL_COD) REFERENCES HOSPITALES (HOSPITAL_COD)
) ENGINE=InnoDB;

INSERT INTO SALA (HOSPITAL_COD, SALA_COD, NOMBRE, NUM_CAMA) 
VALUES 
(13, 3, 'Cuidados Intensivos', 21),
(13, 6, 'Psiquiátrico', 67),
(18, 3, 'Cuidados Intensivos', 10),
(18, 4, 'Cardiología', 53),
(22, 1, 'Recuperación', 10),
(22, 6, 'Psiquiátrico', 118),
(22, 2, 'Maternidad', 34),
(45, 4, 'Cardiología', 55),
(45, 1, 'Recuperación', 13),
(45, 2, 'Maternidad', 24),
(15, 4, 'Cardiología', 20),
(15, 3, 'Cuidados Intensivos', 20);


-- PLANTILLA
CREATE TABLE PLANTILLA (
    HOSPITAL_COD INT(2) NOT NULL,
    SALA_COD INT(2) NOT NULL,
    EMPLEADO_NO INT(4),
    APELLIDO VARCHAR(15),
    FUNCION CHAR(10),
    TURNO CHAR(1),
    SALARIO DECIMAL(10, 2),
    PRIMARY KEY (EMPLEADO_NO),
    FOREIGN KEY (HOSPITAL_COD) REFERENCES HOSPITALES (HOSPITAL_COD),
    FOREIGN KEY (HOSPITAL_COD, SALA_COD) REFERENCES SALA (HOSPITAL_COD, SALA_COD),
    CHECK (TURNO IN ('T', 'M', 'N')),
    CHECK (SALARIO > 0)
) ENGINE=InnoDB;

INSERT INTO PLANTILLA (HOSPITAL_COD, SALA_COD, EMPLEADO_NO, APELLIDO, FUNCION, TURNO, SALARIO) 
VALUES 
(13, 6, 3754, 'Diaz B.', 'Enfermera', 'T', 2262),
(13, 6, 3106, 'Hernandez J.', 'Enfermero', 'T', 2755),
(18, 4, 6357, 'Karplus W.', 'Interno', 'T', 3379),
(22, 6, 1009, 'Higueras D.', 'Enfermera', 'T', 2005),
(22, 6, 8422, 'Bocina G.', 'Enfermero', 'M', 1638),
(22, 2, 9901, 'Nuñez C.', 'Interno', 'M', 2210),
(22, 1, 6065, 'Rivera G.', 'Enfermera', 'N', 1626),
(22, 1, 7379, 'Ramos R.', 'Enfermera', 'T', 2119),
(22, 2, 1234, 'Garcia J.', 'Enfermero', 'M', 3000),
(45, 4, 1280, 'Amigo R.', 'Interno', 'N', 2210),
(45, 1, 8526, 'Frank H.', 'Enfermera', 'T', 2522),
(15, 4, 4234, 'Martinez M.', 'Enfermero', 'T', 2500),
(15, 4, 4400, 'Fernandez R.', 'Enfermero', 'M', 2500),
(15, 4, 1200, 'Urruti A.', 'Interna', 'M', 2500),
(15, 3, 1201, 'Sarabia A.', 'Enfermera', 'T', 2600),
(15, 3, 1203, 'Moreno L.', 'Interno', 'T', 2600);

-- ENFERMO
CREATE TABLE ENFERMO (
    INSCRIPCION INT(5),
    APELLIDO VARCHAR(15),
    DIRECCION VARCHAR(20),
    FECHA_NAC DATE,
    S CHAR(1),
    NSS CHAR(9),
    PRIMARY KEY (INSCRIPCION)
) ENGINE=InnoDB;

INSERT INTO ENFERMO (INSCRIPCION, APELLIDO, DIRECCION, FECHA_NAC, S, NSS) 
VALUES 
(10995, 'Laguia M.', 'Recoletos 50', '1967-06-23', 'M', '280862482'),
(18004, 'Serrano V.', 'Alcala 12', '1960-05-21', 'F', '284991452'),
(14024, 'Fernandez M', 'Recoletos 50', '1967-06-23', 'F', '321790059'),
(36658, 'Domin S.', 'Mayor 71', '1942-01-01', 'M', '160657471'),
(38702, 'Neal R.', 'Orense 11', '1940-06-18', 'F', '380010217'),
(39217, 'Cervantes', 'M.Peron 38', '1952-02-29', 'M', '440294390'),
(59076, 'Miller G.', 'Lopez de Hoyos 2', '1945-09-16', 'F', '311969044'),
(63827, 'Ruiz P.', 'Esquerdo 103', '1980-12-26', 'M', '100973253'),
(64823, 'Fraser A.', 'Soto 3', '1980-07-10', 'F', '285201776'),
(74835, 'Benitez E.', 'Argentina 5', '1957-10-05', 'M', '154811767');


-- OCUPACION
CREATE TABLE OCUPACION (
    INSCRIPCION INT(5) NOT NULL,
    HOSPITAL_COD INT(2),
    SALA_COD INT(2),
    CAMA INT(4),
    PRIMARY KEY (INSCRIPCION, HOSPITAL_COD, SALA_COD),
    FOREIGN KEY (HOSPITAL_COD) REFERENCES HOSPITALES (HOSPITAL_COD),
    FOREIGN KEY (HOSPITAL_COD, SALA_COD) REFERENCES SALA (HOSPITAL_COD, SALA_COD),
    FOREIGN KEY (INSCRIPCION) REFERENCES ENFERMO (INSCRIPCION)
) ENGINE=InnoDB;

INSERT INTO OCUPACION (INSCRIPCION, HOSPITAL_COD, SALA_COD, CAMA) 
VALUES 
(10995, 13, 6, 1),
(18004, 13, 3, 2),
(14024, 13, 3, 3),
(36658, 18, 4, 1),
(38702, 18, 4, 2),
(39217, 22, 6, 1),
(59076, 22, 6, 2),
(63827, 22, 1, 3),
(64823, 22, 2, 1),
(74835, 45, 4, 1);


-- DOCTOR
CREATE TABLE DOCTOR (
    DOCTOR_NO INT(3) NOT NULL,
    APELLIDO VARCHAR(50),
    ESPECIALIDAD VARCHAR(16),
    PRIMARY KEY (DOCTOR_NO)
) ENGINE=InnoDB;

INSERT INTO DOCTOR (DOCTOR_NO, APELLIDO, ESPECIALIDAD) 
VALUES 
(198, 'Doctor Ejemplo 1', 'Especialidad X'),
(186, 'Doctor Ejemplo 2', 'Especialidad Y'),
(435, 'Lopez A.', 'Cardiología'),
(585, 'Miller G.', 'Ginecología'),
(982, 'Cajal R.', 'Cardiología'),
(453, 'Galo D.', 'Pediatría'),
(398, 'Best K.', 'Urología'),
(386, 'Cabeza D.', 'Psiquiatría'),
(607, 'Niqo P.', 'Pediatría'),
(701, 'Martin P.', 'Oftalmología'),
(702, 'Fernande S.', 'Digestivo');





CREATE TABLE DOCTOR_HOSPITAL(
  HOSPITAL_COD INT(2) NOT NULL,
  DOCTOR_NO INT(3) NOT NULL,
  PRIMARY KEY (HOSPITAL_COD, DOCTOR_NO),
  FOREIGN KEY (HOSPITAL_COD) REFERENCES HOSPITALES (HOSPITAL_COD),
  FOREIGN KEY (DOCTOR_NO) REFERENCES DOCTOR (DOCTOR_NO)
);

INSERT INTO DOCTOR_HOSPITAL (HOSPITAL_COD, DOCTOR_NO) VALUES 
(13, 435),
(13, 585),
(13, 982),
(13, 607),
(13, 702),
(18, 435),
(18, 453),
(18, 398),
(18, 607),
(18, 982),
(22, 453),
(22, 398),
(22, 386),
(22, 607),
(22, 701),
(45, 607),
(45, 435),
(45, 453),
(45, 398),
(45, 386),
(25, 198),
(25, 186);

- Nuevas salas

CREATE TABLE NUEVAS_SALAS(
  HOSPITAL_COD INT(2) NOT NULL,
  SALA_COD INT(2),
  NOMBRE VARCHAR(20),
  NUM_CAMA INT(3)
);

INSERT INTO NUEVAS_SALAS (HOSPITAL_COD, SALA_COD, NOMBRE, NUM_CAMA) VALUES 
(15, 3, 'Cuidados Intensivos', 20), 
(11, 1, 'Vigilancia Salud', 5), 
(15, 5, 'Geriatria', 25), 
(15, 8, 'Obstetricia', 18), 
(45, 8, 'Obstetricia', 22),
(18, 2, 'Maternidad', 15),
(18, 1, 'Vigilancia Salud', 5);

-- Resumen hospitales

CREATE TABLE RESUMEN_HOSPITALES(
  HOSPITAL_COD INT(2) NOT NULL,
  NUM_DOCTORES INT(3) DEFAULT 0, 
  NUM_SALAS INT(3) DEFAULT 0, 
  NUM_ENFERMOS INT(3) DEFAULT 0, 
  NUM_PLANTILLA INT(3) DEFAULT 0, 
  PRIMARY KEY (HOSPITAL_COD),
  FOREIGN KEY (HOSPITAL_COD) REFERENCES HOSPITALES(HOSPITAL_COD)  -- Especificamos la columna que se referencia en HOSPITALES
);


INSERT INTO RESUMEN_HOSPITALES (HOSPITAL_COD, NUM_DOCTORES, NUM_SALAS, NUM_ENFERMOS, NUM_PLANTILLA) VALUES 
(18, 5, 4, 2, 1),
(25, 2, 2, 2, 2); 

COMMIT;
