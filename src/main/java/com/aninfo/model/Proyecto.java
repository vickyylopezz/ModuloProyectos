package com.aninfo.model;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

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

    public Long getCodigo() { return codigo; }

    public void setCodigo(Long codigo) { this.codigo = codigo; }

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

