package org.alvarowau.serice;

import org.alvarowau.model.Empleado;
import org.alvarowau.model.Hospital;
import org.alvarowau.model.Sala;
import org.alvarowau.repository.Repository;
import org.alvarowau.repository.RepositoryImpl;

import java.util.List;

public class HospitalService {

    private final Repository repository;
    public HospitalService(){
        repository = new RepositoryImpl();
    }

    public List<Hospital> getAllHospital(){
        List<Hospital> hospitales = repository.getAllHospital();
        for (Hospital hospital : hospitales){
            hospital.setSalas(repository.getSalasByHospitalCod(hospital.getCodHospital()));
            hospital.setPlantilla(repository.getEmpleadosByHospitalCod(hospital.getCodHospital()));
        }
        return hospitales;
    }


}
