/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.rest;

import com.example.plan.entity.Autor;
import com.example.plan.serviceImpl.AutorService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/autor")
public class AutorRestController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/all")
    public List<Autor> getPosts() {
        return autorService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getPost(@PathVariable int id) {
        Autor autor = autorService.read(id);
        return ResponseEntity.ok(autor);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {        
        autorService.delete(id);
    }
    @PostMapping("/add")
    public Autor addPost(@RequestBody Autor autor, @RequestParam("foto") MultipartFile imagen) {  
        if(imagen.isEmpty()){
            //Path dirimg = Paths.get("src//main//resources//static/images");
            //String ruta = dirimg.toFile().getAbsolutePath();
            String ruta = "E://recursos//images//autor";
            
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutacompleta = Paths.get(ruta+"//"+imagen.getOriginalFilename());
                Files.write(rutacompleta, bytesImg);
                autor.setFoto(imagen.getOriginalFilename());
            } catch (IOException e) {
                System.out.println("Error: "+e);
            }
        }
        return autorService.create(autor);
    }
    @PutMapping("/edit")
    public Autor editPost(@RequestBody Autor autor) {  
        //Autor aut = new Autor(autor.getId(),autor.getNombres(),autor.getApellidos(), autor.getEstado());        
        return autorService.update(autor);
    }
}
