
package com.example.plan.serviceImpl;

import com.example.plan.entity.Autor;
import java.util.List;

/**
 *
 * @author admin
 */
public interface AutorService {
    Autor create(Autor autor);
    Autor update(Autor autor);
    void delete(int id);
    Autor read(int id);
    List<Autor> readAll();
}
