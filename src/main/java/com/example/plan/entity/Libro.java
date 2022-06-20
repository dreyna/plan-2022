
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
@Table(name = "libro")
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idlibro")
    private int id;
    private String titulo;
    private String edicion;
    @ManyToOne
    @JoinColumn(name = "idautor")
    private Autor autor;
    @ManyToOne
    @JoinColumn(name = "ideditorial")
    private Editorial editorial;
    private String imagen;
    private int anos;
    
}
