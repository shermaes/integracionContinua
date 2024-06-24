package com.poli.backend.facturacion.models.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Factura")
@Table(name = "factura")
@Data
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idFactura;

    private int idCliente;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Producto> productos = new ArrayList<>();
    private Long impuestos;
    private Long total;
    private String fecha;

    public Factura addProducto(Producto producto) {
        this.productos.add(producto);
        return this;
    }
}
