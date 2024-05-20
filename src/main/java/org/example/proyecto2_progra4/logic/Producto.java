package org.example.proyecto2_progra4.logic;

public class Producto {
    String id;
    String categoria;
    String description;
    String unidad_Medida;
    double cost;

    public Producto() {
        this.id = "";
        this.categoria="";
        this.description="";
        this.unidad_Medida="";
        this.cost=0;
    }

    public Producto(String id, String categoria, String description, String unidad_Medida, double cost) {
        this.id = id;
        this.categoria= categoria;
        this.description = description;
        this.unidad_Medida=unidad_Medida;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnidadM() {
        return unidad_Medida;
    }

    public void setUnidadM(String unidadM) {
        this.unidad_Medida = unidadM;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
