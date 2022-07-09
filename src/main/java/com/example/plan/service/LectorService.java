/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.plan.service;

import com.example.plan.entity.Lector;
import java.util.List;

/**
 *
 * @author admin
 */
public interface LectorService {
    Lector create(Lector lector);
    Lector update(Lector lector);
    void delete(int id);
    Lector read(int id);
    List<Lector> readAll();
}
