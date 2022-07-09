
package com.example.plan.controller;

import com.example.plan.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author admin
 */
@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;
    
    @GetMapping
    public String indexLibro(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("empleados", empleadoService.readAll());
        return "empleado/listarEmpleado";
    }
}
