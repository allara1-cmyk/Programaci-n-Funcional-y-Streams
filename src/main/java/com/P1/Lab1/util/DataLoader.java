package com.P1.Lab1.util;

import com.P1.Lab1.model.Producto;
import com.P1.Lab1.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductoRepository productoRepository;

    public DataLoader(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Producto> productos = Arrays.asList(
                new Producto(null, "Audifonos BT", "Electrónica", 45.99, 50, true),
                new Producto(null, "Laptop Pro", "Electrónica", 1200.00, 15, true),
                new Producto(null, "Mouse Inalámbrico", "Electrónica", 25.50, 100, true),
                new Producto(null, "Teclado Mecánico", "Electrónica", 85.00, 30, true),
                new Producto(null, "Monitor 24 pulgadas", "Electrónica", 150.00, 20, true),
                new Producto(null, "Silla Gamer", "Muebles", 200.00, 10, true),
                new Producto(null, "Escritorio", "Muebles", 180.00, 12, true),
                new Producto(null, "Webcam 1080p", "Electrónica", 60.00, 40, true),
                new Producto(null, "Micrófono Condensador", "Electrónica", 90.00, 25, true),
                new Producto(null, "Mochila para Laptop", "Accesorios", 35.00, 60, true)
        );

        productoRepository.saveAll(productos);
        System.out.println("--- 10 productos han sido guardados en la base de datos ---");
    }
}
