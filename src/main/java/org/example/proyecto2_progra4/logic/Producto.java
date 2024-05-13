package org.example.proyecto2_progra4.logic;

public class Producto {
    int id;
    String categoria;
    String description;
    double cost;

    public Producto() {
        this.id = 0;
        this.categoria="";
        this.description="";
        this.cost=0;
    }

    public Producto(int id, String categoria, String description, double cost) {
        this.id = id;
        this.categoria= categoria;
        this.description = description;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
