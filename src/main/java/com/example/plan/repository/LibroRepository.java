
package com.example.plan.repository;

import com.example.plan.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{
    
}
