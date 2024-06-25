package com.poli.backend.facturacion.models.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "Producto")
@Table(name = "producto")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private Integer cantidad;
    private double precio;
    private Long fkFacturaId;

}
