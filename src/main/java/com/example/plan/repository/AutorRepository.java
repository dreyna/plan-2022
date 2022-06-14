package com.example.plan.repository;

import com.example.plan.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer>{
    
}
