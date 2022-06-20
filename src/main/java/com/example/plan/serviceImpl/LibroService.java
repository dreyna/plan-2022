/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.plan.serviceImpl;

import com.example.plan.entity.Libro;
import java.util.List;

/**
 *
 * @author admin
 */
public interface LibroService {
    Libro create(Libro  autor);
    Libro  update(Libro  autor);
    void delete(int id);
    Libro  read(int id);
    List<Libro > readAll();
}
