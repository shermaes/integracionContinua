package com.poli.backend.facturacion.models.dtopattern;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductoDTO implements Serializable {

    private Integer id;
    private String nombre;
    private Integer cantidad;
    private double precio;
    private Long fkFacturaId;
}
