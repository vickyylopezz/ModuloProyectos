package com.aninfo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    private String nombre;
    private String liderDeProyecto;
    private Estado estado;
    private String fechaCreacion;
    private String descripcion;

    public Proyecto() {
    }

    public Proyecto(String nombre, String liderDeProyecto, String fechaCreacion, String descripcion) {
        this.nombre = nombre;
        this.liderDeProyecto = liderDeProyecto;
        this.estado = Estado.CREADO;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;

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

    public void setEstado(Estado estado){
        this.estado = estado;
    }

    public Estado getEstado(){
        return estado;
    }

    public void setFechaCreacion(String fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaCreacion(){
        return fechaCreacion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}

