package com.facturador.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Prueba un producto digital y verifica sus atributos y comportamiento
 * ProductoDigitalTest
 */
class ProductoDigitalTest {

    /**
     * Este test crea un producto Digital y comprueba que se pueda crear correctamente y que sus atributos sean los esperados.
     */
    @Test
    @DisplayName("Debe crear un producto digital y verificar sus atributos")
    void testCrearProductoDigital() {
        Producto encarta = new ProductoDigital("PRODDIGITAL-001", "Encarta", new BigDecimal("10000.00"), Categoria.SOFTWARE, "HTTP://mitiendadigital.com/downloads/software/encarta/","Ax123Fn85P");

        assertThat(encarta).isInstanceOf(Producto.class);
        assertThat(ProductoDigital.class).hasSuperclass(Producto.class);
        assertThat(Producto.class).isAbstract();
        assertThat(encarta.getCodigo()).isEqualTo("PRODDIGITAL-001");
        assertThat(encarta.getNombre()).isEqualTo("Encarta");
        assertThat(encarta.getPrecio()).isEqualTo(new BigDecimal("10000.00"));
        assertThat(encarta.getCategoria()).isEqualTo(Categoria.SOFTWARE);
        assertThat(encarta.getUrl()).isEqualTo("HTTP://mitiendadigital.com/downloads/software/encarta/");
        assertThat(encarta.getClaveLicencia()).isEqualTo("Ax123Fn85P");
        assertThat(encarta.pedirEnvio()).isFalse();
    }

    // @Test
    // @DisplayName("Este test comprueba que no se requieren pedidos de envio para productos digitales")
    // void testCrearProductoDigitalNoRequiereEnvio() {
    //     Producto encarta = new ProductoDigital("PRODDIGITAL-001", "Encarta", new BigDecimal("10000.00"), Categoria.SOFTWARE, "HTTP://mitiendadigital.com/downloads/software/encarta/","Ax123Fn85P");
        
        
    //     assertThat(encarta.pedirEnvio()).isFalse();
    // }
    
}
