package com.ecommerceuserapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AccountRequest {


    private String status;
    private LocalDate fecha_creacion;
    private double saldo;
    private Long id_usuario;

}
