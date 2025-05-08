package org.alvarowau.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;

    private int empleadoCode;
    private String apellido;
}
