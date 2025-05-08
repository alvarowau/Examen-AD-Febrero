package org.alvarowau.model;


import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Hospital implements Serializable {
    private static final long serialVersionUID = 1L;
    private int codHospital;
    private String nombre;
    private String direccion;
    private List<Sala> salas;
    private List<Empleado> plantilla;



}
