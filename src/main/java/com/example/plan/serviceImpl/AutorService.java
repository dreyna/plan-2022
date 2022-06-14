/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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
