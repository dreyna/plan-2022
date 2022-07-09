package com.example.plan.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @OneToMany(mappedBy = "usuario")
    private List<Rol> roles;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "idusuario")
    private List<Prestamo> prestamos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idempleado", referencedColumnName = "idempleado")
    private Empleado empleado;

    private boolean estado;
    public boolean getEstado() {
        return this.estado;
    }
}
