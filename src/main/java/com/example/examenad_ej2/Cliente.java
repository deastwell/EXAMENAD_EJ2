package com.example.examenad_ej2;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Long total;

    private String estado;

    public Cliente() {

    }

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.total = 0L; // Valor predeterminado para el número de ventas
        this.estado = "Activo"; // Valor predeterminado para el estado
    }

    public Cliente(String nombre, Long numeroVentas, String estado) {
        this.nombre = nombre;
        this.total = numeroVentas;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getNumeroVentas() {
        return total;
    }

    public void setNumeroVentas(Long numeroVentas) {
        this.total = numeroVentas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", numeroVentas=" + total +
                ", estado='" + estado + '\'' +
                '}';
    }
}