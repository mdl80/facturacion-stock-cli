package com.facturador.model;

enum Categoria {

    ELECTRONICA("Electronica"), SOFTWARE("Software"), LIBROS("Libros"), HOGAR("Hogar"), OTROS("Otros");

    private final String descripcion;

    Categoria(String descripcion){
        this.descripcion = descripcion;
    }
    
    public String getCategoria(){
        return descripcion;
    }

}
