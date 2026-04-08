package com.Crud.Clientes.demo.Model;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Column(name = "cliente_id")
    @Id
    private String cliente_id;

    private String nombre;
    private LocalDate fechaNacimiento;
    private String direccion;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos;

    public Cliente(String cliente_id, String nombre, LocalDate fechaNacimiento, String direccion){
        this.cliente_id = cliente_id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.productos = new ArrayList<>();
    }
    public Cliente(){}

    public String getID() {
        return cliente_id;
    }

    public void setID(String ID) {
        this.cliente_id = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
