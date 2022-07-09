
package com.example.plan.service;

import com.example.plan.entity.Prestamo;
import java.util.List;

/**
 *
 * @author admin
 */
public interface PrestamoService {
    Prestamo create(Prestamo prestamo);
    Prestamo update(Prestamo prestamo);
    void delete(int id);
    Prestamo read(int id);
    List<Prestamo> readAll();
}
