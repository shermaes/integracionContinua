package com.poli.backend.facturacion.service;

import com.poli.backend.facturacion.models.dtopattern.FacturaDTO;
import com.poli.backend.facturacion.models.entity.Factura;
import com.poli.backend.facturacion.models.entity.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FacturaService {

    FacturaDTO createfactura(Factura factura);

    FacturaDTO createProducto(Producto producto);

    FacturaDTO updateProducto(Producto producto);

    void deleteFactura(Long id);

    void deleteproducto(Long id);

    List<FacturaDTO> findAllFacturas();
}
