/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.plan.serviceImpl;

import com.example.plan.entity.Rol;

/**
 *
 * @author admin
 */
public interface RolService {
    Rol create(Rol rol);
    Rol update(Rol rol);
    void delete(int id);
    
}
