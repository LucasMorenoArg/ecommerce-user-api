package com.ecommerceuserapi.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "usuario", uniqueConstraints = {
        @UniqueConstraint(columnNames = "nroDocumento"),
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "nombreUsuario")
})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    @Column(nullable = false, unique = true)
    private Integer nroDocumento;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String nombreUsuario;


}
