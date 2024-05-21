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
        @UniqueConstraint(columnNames = "nro_documento"),
        @UniqueConstraint(columnNames = "email"),

})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    @Column(name="nro_documento", nullable = false, unique = true)
    private Integer nroDocumento;
    @Column(nullable = false, unique = true)
    private String email;


}
