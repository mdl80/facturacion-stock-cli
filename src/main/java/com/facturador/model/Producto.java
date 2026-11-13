package com.facturador.model;

import java.math.BigDecimal;

/**
 * <h3>Producto</h3>
 * <p>Esta clase define de forma generica(abstracta) un producto
 * esta sellada o tiene un contrato solo con una clase hija "roductoFisico"<p>
 */
public abstract sealed class Producto permits ProductoFisico {
    
    private final String id;
    private final String nombre;
    private final BigDecimal precioUnitario;
    private final Categoria categoria;

    public Producto (String id, String nombre, BigDecimal precioUnitario, Categoria categoria){
        this.id = id;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.categoria = categoria;
        
        if (id == null){
            throw new IllegalArgumentException("Error El ID no puede ser nulo");
        }
        if (nombre == null){
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        if (precioUnitario == null){
            throw new IllegalArgumentException("El precio unitario no puede ser nulo");
        }
        if (precioUnitario.compareTo(BigDecimal.ZERO) <=0){
            throw new IllegalArgumentException("El precio unitario debe ser mayor a 0");
        }    
        if (categoria == null){
            throw new IllegalArgumentException("La categoria no puede ser nula ");
        }
    }

    /**
     * Este metodo debe ser implementado por las clases hijas
     * @return verdadero o falso
     */
    public boolean requiereEnvio(){

    }
    public boolean hayStockDisponible(int cantidadSolicitada){

    }
    void descontarStock(int cantidad){

    }




}
