package com.P1.Lab1.controller;

import com.P1.Lab1.model.Producto;
import com.P1.Lab1.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/validos")
    public List<Producto> obtenerProductosValidos() {
        return productoService.obtenerProductosValidos();
    }

    @GetMapping("/descuento-tecnologia")
    public List<Producto> aplicarDescuentoTecnologia(@RequestParam(defaultValue = "15.0") double porcentaje) {
        return productoService.aplicarDescuentoTecnologia(porcentaje);
    }

    @GetMapping("/catalogo")
    public Map<String, List<String>> generarCatalogoAgrupado() {
        return productoService.generarCatalogoAgrupado();
    }
}
