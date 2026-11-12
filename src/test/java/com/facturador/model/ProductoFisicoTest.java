package com.facturador.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
 
class ProductoFisicoTest { 
    
    @Test
    @DisplayName("Debe crear un producto fisico y pedir envio")
    void crearProductoFisico() {
        // Implementar prueba para crear un producto físico
        ProductoFisico teclado = new ProductoFisico("PROD-001", "Teclado mecánico", new BigDecimal("80000.00"), Categoria.ELECTRONICA, 10, 3 ,1.2);

        assertThat(teclado).isInstanceOf(Producto.class);
        assertThat(ProductoFisico.class).hasSuperclass(Producto.class);
        assertThat(Producto.class).isAbstract();
        assertThat(teclado.getCodigo()).isEqualTo("PROD-001");
        assertThat(teclado.getNombre()).isEqualTo("Teclado mecánico");
        assertThat(teclado.getPrecio()).isEqualTo(new BigDecimal("80000.00"));
        assertThat(teclado.getCategoria()).isEqualTo(Categoria.ELECTRONICA);
        assertThat(teclado.getStock()).isEqualTo(10);
        assertThat(teclado.getStockMinimo()).isEqualTo(3);
        assertThat(teclado.getPeso()).isEqualTo(1.2);
    }

}
