package com.poli.backend.facturacion.controller;

import com.poli.backend.facturacion.models.dtopattern.FacturaDTO;
import com.poli.backend.facturacion.models.entity.Factura;
import com.poli.backend.facturacion.models.entity.Producto;
import com.poli.backend.facturacion.service.FacturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:3000/")
public class Controller {

    private FacturaService facturaService;

    @GetMapping("get/facturas")
    public List<FacturaDTO> getAllFacturas() {
        return facturaService.findAllFacturas();
    }

    @PostMapping("save/factura")
    public FacturaDTO createFactura(@RequestBody Factura factura) {
        return facturaService.createfactura(factura);
    }

    @PostMapping("save/producto")
    public FacturaDTO createProducto(@RequestBody Producto producto) {
        return facturaService.createProducto(producto);
    }

    @PutMapping("update/producto")
    public FacturaDTO updateProducto(@RequestBody Producto producto) {
        return facturaService.updateProducto(producto);
    }

    @DeleteMapping("delete/factura/{id}")
    public void deleteFactura(@PathVariable Long id) {
        facturaService.deleteFactura(id);
    }

    @DeleteMapping("delete/producto/{id}")
    public void deleteProducto(@PathVariable Long id) {
        facturaService.deleteproducto(id);
    }


}
