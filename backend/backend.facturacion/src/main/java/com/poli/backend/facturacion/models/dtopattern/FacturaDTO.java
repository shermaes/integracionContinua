package com.poli.backend.facturacion.models.dtopattern;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class FacturaDTO implements Serializable {

    private Integer idFactura;
    private Integer idCliente;
    private List<ProductoDTO> productos = new ArrayList<>();
    private Long impuestos;
    private Long total;
    private String fecha;

}
