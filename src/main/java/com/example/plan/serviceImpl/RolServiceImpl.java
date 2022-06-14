/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.serviceImpl;

import com.example.plan.entity.Rol;
import com.example.plan.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class RolServiceImpl implements RolService{
    @Autowired
    private RolRepository rolRepository;    

    @Override
    public Rol create(Rol rol) {
        return rolRepository.save(rol);        
    }

    @Override
    public Rol update(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public void delete(int id) {
        rolRepository.deleteById(id);
    }
}
