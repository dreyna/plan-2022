
package com.example.plan.serviceImpl;

import com.example.plan.entity.Detalle;
import com.example.plan.repository.DetalleRepository;
import com.example.plan.service.DetalleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class DetalleServiceImpl implements DetalleService {

    @Autowired
    private DetalleRepository detalleRepository;
    @Override
    public Detalle create(Detalle detalle) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Detalle update(Detalle detalle) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Detalle read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Detalle> readAll() {
        return detalleRepository.findAll();
    }
    
}
