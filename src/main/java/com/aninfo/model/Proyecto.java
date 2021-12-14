package com.aninfo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String liderDeProyecto;
    private String estado;
    private LocalDateTime fechaCreacion;
    private String descripcion;

    public Proyecto() {
    }

    public Proyecto(String nombre, String liderDeProyecto, String descripcion) {
        this.nombre = nombre;
        this.liderDeProyecto = liderDeProyecto;
        this.estado = "CREADO";
        this.descripcion = descripcion;
        this.fechaCreacion = LocalDateTime.now();

    }

    public Long getId() { return id; }

    public void setId(Long codigo) { this.id = codigo; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setLiderDeProyecto(String liderDeProyecto){
        this.liderDeProyecto = liderDeProyecto;
    }

    public String getLiderDeProyecto(){
        return liderDeProyecto;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public String getEstado(){
        return estado;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaCreacion(){
        return fechaCreacion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}

