package com.facturador.model;

import java.math.BigDecimal;

/**
 * <h3>Producto</h3>
 * <p>Esta clase define de forma generica(abstracta) un producto
 * esta sellada o tiene un contrato solo con una clase hija "ProductoFisico"<p>
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
     * Este metodo devuelve el id de un Producto
     * @return String Codigo del Producto
     */
    public String getId(){
        return this.id;
    }

    /**
     * Este metodo devuelve el nombre de un producto
     * @return String nombre del producto
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Este metodo devuelve el precio unitario de un Producto
     * @return BigDecimal
     */
    public BigDecimal getPrecioUnitario(){
        return this.precioUnitario;
    }

    /**
      * Este metodo devuelve la catergoria de un producto
      * @return
      */
    public Categoria getCategoria(){
        return this.categoria;
    }  
    
    /**
     * Este metodo debe ser implementado por las clases hijas
     * @return verdadero o falso
     */
    public abstract boolean requiereEnvio();
    public abstract boolean hayStockDisponible(int cantidadSolicitada);
    public abstract void descontarStock(int cantidad);




}
