package org.alvarowau.ejercicios;

import org.alvarowau.model.Hospital;
import org.alvarowau.serice.CreacionArchivoService;
import org.alvarowau.serice.HospitalService;

import java.util.List;

public class Ejercicio1 {

    private Ejercicio1(){}

    public static void start(){
        HospitalService service = new HospitalService();
        List<Hospital> hospitals = service.getAllHospital();
//        for (Hospital hospital : hospitals) {
//            System.out.println(hospital);
//        }
        CreacionArchivoService creacionArchivoService = new CreacionArchivoService();
        creacionArchivoService.crearArchivoHospitales(hospitals);
    }
}
