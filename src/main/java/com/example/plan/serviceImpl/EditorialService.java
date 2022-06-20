/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.plan.serviceImpl;

import com.example.plan.entity.Editorial;
import java.util.List;

/**
 *
 * @author admin
 */
public interface EditorialService {
    Editorial create(Editorial editorial);
    Editorial update(Editorial editorial);
    void delete(int id);
    Editorial read(int id);
    List<Editorial> readAll();
}
