package com.facturador.model;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
 
class ProductoFisicoTest { 
    
    /**
     * Prueba para crear un producto físico y verificar sus atributos.
     */
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

    /**
     * Prueba para crear un producto físico, descontar stock y verificar que se pida envío.
     */
    @Test 
    @DisplayName("Debre crear un producto, descontar stock y verificar que se pida envio")
    void crearProductoDescontarStockPedirEnvio() {
        ProductoFisico teclado = new ProductoFisico("PROD-001", "Teclado mecánico", new BigDecimal("80000.00"), Categoria.ELECTRONICA, 10, 3 ,1.2);
        //Descontar Stock
        teclado.descontarStock(8);
        
        //verificar que el stock sea igual a 2
        assertThat(teclado.getStock()).isEqualTo(2);
        //verificar que se debe pedir envio ya que el stock es menor al stock minimo
        assertThat(teclado.pedirEnvio()).isTrue();
    }

    /**
     * Prueba para crear un producto físico y verificar que se lance una excepción cuando el stock es menor al pedido.
     * El stock no debe cambiar si se lanza la excepción.
     */
    @Test 
    @DisplayName ("Debe lanzar excepcion por stock menor al pedido")
    void crearProductoDescontarStockMenorAlPedido() {
        ProductoFisico teclado = new ProductoFisico("PROD-001", "Teclado mecánico", new BigDecimal("80000.00"), Categoria.ELECTRONICA, 10, 2 ,1.2);
        
        //verificar que se lance la excepcion al intentar descontar mas stock del disponible
        assertThatThrownBy(() -> teclado.descontarStock(11))
            .isInstanceOf(StockInsuficienteException.class)
            .hasMessageContaining("No hay suficiente stock disponible para descontar de" + teclado.getNombre());
        //el stock debe quedar inalterado
        assertThat(teclado.getStock()).isEqualTo(10);
    }
    /**
     * Prueba para crear un producto fisico con precio o stock negativo y verificar que se lance una excepción.
     */
    @Test 
    @DisplayName ("Debe lanzar excepcion por precio o stock negativo")
    void crearProductoFisicoPrecioStockNegativo() {
        //verificar que se lance la excepcion al intentar crear un producto con precio negativo
        assertThatThrownBy(() -> new ProductoFisico("PROD-001", "Teclado mecánico", new BigDecimal("-80000.00"), Categoria.ELECTRONICA, 10, 2 ,1.2))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("El precio no puede ser negativo");
        
        //verificar que se lance la excepcion al intentar crear un producto con stock negativo
        assertThatThrownBy(() -> new ProductoFisico("PROD-001", "Teclado mecánico", new BigDecimal("80000.00"), Categoria.ELECTRONICA, -10, 2 ,1.2))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("El stock no puede ser negativo");
    }

    /**
     * Prueba que lanza una excepcion si se intenta descontaar una cantidad menor o igual a cero del stock de un producto fisico.
     */
    @Test 
    @DisplayName ("Debe lanzar excepcion por cantidad a descontar menor o igual a cero")
    void crearProductoFisicoDescontarStockMenorIgualCero() {
        ProductoFisico teclado = new ProductoFisico("PROD-001", "Teclado mecánico", new BigDecimal("80000.00"), Categoria.ELECTRONICA, 10, 2 ,1.2);
        
        //verificar que se lance la excepcion al intentar descontar una cantidad igual a cero
        assertThatThrownBy(() -> teclado.descontarStock(0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("La cantidad a descontar debe ser mayor a cero");
            
        //verificar que se lance la excepcion al intentar descontar una cantidad menor a cero
        assertThatThrownBy(() -> teclado.descontarStock(-5))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("La cantidad a descontar debe ser mayor a cero");
    }
}
