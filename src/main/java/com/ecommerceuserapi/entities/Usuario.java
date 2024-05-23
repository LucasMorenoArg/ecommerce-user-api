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


})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    @Column(name="nro_documento")
    private Integer nroDocumento;
    private String email;
    @Enumerated(EnumType.STRING)
    private Status estado;
}
