
package com.example.plan.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "prestamo")
public class Prestamo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idprestamo")
    private int id;
    private String fecha_salida;
    private boolean estado;
    @ManyToOne
    @JoinColumn(name = "idlector")
    private Lector lector;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;
    @OneToMany
    @JoinColumn(name="idprestamo")
    private List<Detalle> detalle;
}
