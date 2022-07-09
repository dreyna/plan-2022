
package com.example.plan.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author admin
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "detalle")
public class Detalle implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="iddetalle")
    private int id;
    private String fecha_fecha_devol;
    private double mora;
    private boolean estado;
    @ManyToOne
    @JoinColumn(name = "idprestamo")
    private Prestamo prestamo;
    @ManyToOne
    @JoinColumn(name = "idlibro")
    private Libro libro;
    
}
