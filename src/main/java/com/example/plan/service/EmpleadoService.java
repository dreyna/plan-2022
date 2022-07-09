
package com.example.plan.service;

import com.example.plan.entity.Empleado;
import java.util.List;

/**
 *
 * @author admin
 */
public interface EmpleadoService {
    Empleado create(Empleado empleado);
    Empleado update(Empleado empleado);
    void delete(int id);
    Empleado read(int id);
    List<Empleado> readAll();
}
