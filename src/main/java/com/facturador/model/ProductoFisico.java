package com.facturador.model;

import java.math.BigDecimal;

public final class ProductoFisico extends Producto{

    private int stockActual;
    private int stockMinimo;
    private double pesoKg;

    public ProductoFisico (String id, String nombre, BigDecimal precioUnitario, Categoria categoria, 
                            int stockActual, int stockMinimo, double pesoKg){
        super(id, nombre, precioUnitario, categoria);
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.pesoKg = pesoKg;

        if (stockActual < 0){
            throw new IllegalArgumentException("El valor debe ser mayor a cero");
            }
        if (stockMinimo < 0){
            throw new IllegalArgumentException("El valor debe ser mayor a cero");
            }
        if (pesoKg <= 0){
            throw new  IllegalArgumentException("El peso debe ser mayor a cero");
            }
        }


        /**
         * Este metodo devuelve el valor de stockActual de la instancia
         * @return int Stock actual
         */
        public int getStockActual(){
            return this.stockActual;
        }

        public int getStockMinimo() {
            return this.stockMinimo;
        }

        public double getPesoKg() {
            return this.pesoKg;
        }

        @Override
        public boolean requiereEnvio(){
            if (stockActual < stockMinimo){
                return true;
            }
            return false; 
        }

        // /**        
        //  * Este metodo descuenta la cantidad de productos vendidos del stock actual
        //  * @cantidad int , cantidad de elementos a vender
        //  * @IllegalArgumentException si la cantidad a vender es menor o igual a 0
        //  * @StockInsuficienteException si es stock no cubre la cantidad a vender
        //  */
        // @Override 
        // public void descontarStock(int cantidad){
        //     if( cantidad <=0 ){
        //         throw new IllegalArgumentException("la cantidad debe ser mayor a 0");
        //     }
        //     if( cantidad > this.getStockActual() ){
        //         throw new StockInsuficienteException("Stock insuficiente");
        //     }

        //     this.stockActual = this.stockActual - cantidad ;
        // }

        // @Override 
        // public boolean hayStockDisponible(int cantidad){
        //     return true;
        // }
    
    }
