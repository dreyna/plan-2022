
package com.example.plan.service;

import com.example.plan.entity.Detalle;
import java.util.List;

/**
 *
 * @author admin
 */
public interface DetalleService {
    Detalle create(Detalle detalle);
    Detalle update(Detalle detalle);
    void delete(int id);
    Detalle read(int id);
    List<Detalle> readAll();
}
