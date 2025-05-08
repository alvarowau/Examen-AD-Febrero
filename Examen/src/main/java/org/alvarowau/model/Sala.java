package org.alvarowau.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Sala implements Serializable {

    private static final long serialVersionUID = 1L;
    private int salaCod;
    private String nombre;
}
