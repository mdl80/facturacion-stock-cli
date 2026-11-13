package com.facturador.model;

import java.math.BigDecimal;

public final class ProductoFisico extends Producto{

    private int stockActual;
    private int stockMinimo;
    private double pesoKg;

    public ProductoFisico (String id, String nombre, BigDecimal precioUnitario, Categoria categoria, int stockActual, int stockMinimo, double pesoKg){
        super(id, nombre, precioUnitario, categoria);
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.pesoKg = pesoKg;

        if (stockActual >= 0){
            throw new IllegalArgumentException("El valor debe ser mayor a cero");
        }
        if (stockMinimo >= 0)
            throw new IllegalArgumentException("El valor debe ser mayor a cero");
        if (pesoKg > 0){
            throw new  IllegalArgumentException("El peso debe ser mayor a cero");
        }
    }



    
}
