package org.example.proyecto2_progra4.logic;

import java.util.List;

public class Factura {
    int id;
    Proveedor prov;
    Cliente client;
    double costoTotal;
    List<Producto> productoList;

    public Factura() {
    }

    public Factura(int id, Proveedor prov, Cliente client, double costoTotal, List<Producto> productoList) {
        this.id = id;
        this.prov = prov;
        this.client = client;
        this.costoTotal = costoTotal;
        this.productoList = productoList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Proveedor getProv() {
        return prov;
    }

    public void setProv(Proveedor prov) {
        this.prov = prov;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }
}
