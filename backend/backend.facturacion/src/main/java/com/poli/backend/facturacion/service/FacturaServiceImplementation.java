package com.poli.backend.facturacion.service;

import com.poli.backend.facturacion.models.dtopattern.FacturaDTO;
import com.poli.backend.facturacion.models.entity.Factura;
import com.poli.backend.facturacion.models.entity.Producto;
import com.poli.backend.facturacion.repository.FacturaRepository;
import com.poli.backend.facturacion.repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturaServiceImplementation implements FacturaService {

    private FacturaRepository facturaRepository;
    private ProductoRepository productoRepository;
    private ModelMapper modelMapper;

    @Override
    public FacturaDTO createfactura(Factura factura) {
        return convertEntityToDTO(facturaRepository.save(factura));
    }

    @Override
    public FacturaDTO createProducto(Producto producto) {
        Factura factura = facturaRepository.findById(producto.getFkFacturaId()).get();
        factura.addProducto(producto);
        productoRepository.save(producto);
        return convertEntityToDTO(facturaRepository.save(factura));
    }

    @Override
    public FacturaDTO updateProducto(Producto producto) {
        Factura factura = facturaRepository.findById(producto.getFkFacturaId()).get();
        productoRepository.save(producto);
        return convertEntityToDTO(facturaRepository.save(factura));
    }

    @Override
    public void deleteFactura(Long id) {
        facturaRepository.deleteById(id);
    }

    @Override
    public void deleteproducto(Long id) {
        productoRepository.deleteById(id);

    }

    @Override
    public List<FacturaDTO> findAllFacturas() {
        return facturaRepository.findAll().stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    private FacturaDTO convertEntityToDTO(Factura factura) {

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        FacturaDTO facturaDTODTO = new FacturaDTO();

        facturaDTODTO = modelMapper.map(factura, FacturaDTO.class);
        return facturaDTODTO;
    }

}
