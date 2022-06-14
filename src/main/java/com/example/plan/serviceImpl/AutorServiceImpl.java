package com.example.plan.serviceImpl;

import com.example.plan.entity.Autor;
import com.example.plan.repository.AutorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class AutorServiceImpl implements AutorService {
@Autowired
private AutorRepository autorRepository;
    @Override
    public Autor create(Autor autor) {
        return autorRepository.save(autor);        
    }

    @Override
    public Autor update(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public void delete(int id) {
        autorRepository.deleteById(id);
    }

    @Override
    public Autor read(int id) {
        return autorRepository.findById(id).get();
    }

    @Override
    public List<Autor> readAll() {
        return autorRepository.findAll();
    }
    
}
