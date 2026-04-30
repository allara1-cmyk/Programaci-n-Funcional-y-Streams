package com.P1.Lab1.service;

import com.P1.Lab1.model.Producto;
import com.P1.Lab1.repository.ProductoRepository;
import com.P1.Lab1.util.FuncionalUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> obtenerProductosValidos() {
        return productoRepository.findAll().stream()
                .filter(p -> FuncionalUtils.ValidadorProducto.validarPrecioPositivo().validar(p) && 
                             FuncionalUtils.ValidadorProducto.validarEsActivo().validar(p))
                .collect(Collectors.toList());
    }

    public List<Producto> aplicarDescuentoTecnologia(double porcentaje) {
        return productoRepository.findAll().stream()
                .filter(p -> p.getCategoria() != null && p.getCategoria().equalsIgnoreCase("Tecnología"))
                .map(p -> FuncionalUtils.TransformadorProducto.aplicarDescuento(porcentaje).transformar(p))
                .collect(Collectors.toList());
    }

    public Map<String, List<String>> generarCatalogoAgrupado() {
        return productoRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.mapping(
                                p -> FuncionalUtils.FormateadorProducto.formatoResumen().formatear(p),
                                Collectors.toList()
                        )
                ));
    }
}
