package com.mycompany.sistema_ventas.modelo;

import javax.persistence.*;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String descripcion;
    
    @Basic
    private double precio;
    
    private int stock;
    
    public Producto() {
        // Constructor vacío para JPA
    }
    
    public Producto(String descripcion, double precio, int stock) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
