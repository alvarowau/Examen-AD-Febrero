package org.alvarowau.repository;

import org.alvarowau.model.Empleado;
import org.alvarowau.model.Hospital;
import org.alvarowau.model.Sala;

import java.util.List;

public interface Repository {
    List<Hospital> getAllHospital();
    List<Empleado> getEmpleadosByHospitalCod(int hospitalCod);
    List<Sala> getSalasByHospitalCod(int hospitalCod);
}
