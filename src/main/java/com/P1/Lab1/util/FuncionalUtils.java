package com.P1.Lab1.util;

import com.P1.Lab1.model.Producto;

public class FuncionalUtils {

    @FunctionalInterface
    public interface ValidadorProducto {
        boolean validar(Producto producto);

        static ValidadorProducto validarPrecioPositivo() {
            return p -> p != null && p.getPrecio() != null && p.getPrecio() > 0;
        }

        static ValidadorProducto validarStockMinimo(int minimo) {
            return p -> p != null && p.getStock() != null && p.getStock() >= minimo;
        }

        static ValidadorProducto validarEsActivo() {
            return p -> p != null && Boolean.TRUE.equals(p.getActivo());
        }
    }

    @FunctionalInterface
    public interface TransformadorProducto {
        Producto transformar(Producto producto);

        static TransformadorProducto aplicarDescuento(double porcentaje) {
            return p -> {
                if (p != null && p.getPrecio() != null) {
                    p.setPrecio(p.getPrecio() - (p.getPrecio() * (porcentaje / 100.0)));
                }
                return p;
            };
        }

        static TransformadorProducto desactivar() {
            return p -> {
                if (p != null) {
                    p.setActivo(false);
                }
                return p;
            };
        }
    }

    @FunctionalInterface
    public interface FormateadorProducto {
        String formatear(Producto producto);

        static FormateadorProducto formatoResumen() {
            return p -> {
                if (p == null) return "Producto no disponible";
                return String.format("Resumen -> Nombre: %s | Categoría: %s | Precio: $%.2f | Stock: %d",
                        p.getNombre(), p.getCategoria(), p.getPrecio(), p.getStock());
            };
        }

        static FormateadorProducto formatoEtiqueta() {
            return p -> {
                if (p == null) return "ETIQUETA NULA";
                return String.format("ETIQUETA: [%s] %s - $%.2f",
                        p.getCategoria() != null ? p.getCategoria().toUpperCase() : "S/C", 
                        p.getNombre(), 
                        p.getPrecio());
            };
        }
    }
}
