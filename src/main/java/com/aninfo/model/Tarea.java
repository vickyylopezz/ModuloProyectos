package com.aninfo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long codigoProyecto;
    private String nombre;
    private String estado;
    private String descripcion;
    private Integer legajoPersonaAsignada;

    public Tarea() {
    }

    public Tarea(Long codigoProyecto, String nombre, String descripcion, Integer legajoPersonaAsignada) {
        this.codigoProyecto = codigoProyecto;
        this.nombre = nombre;
        this.estado = "CREADA";
        this.descripcion = descripcion;
        this.legajoPersonaAsignada = legajoPersonaAsignada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long codigoTarea) {
        this.id = codigoTarea;
    }

    public Long getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(Long codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getLegajoPersonaAsignada() {
        return legajoPersonaAsignada;
    }

    public void setLegajoPersonaAsignada(Integer personaAsignada) {
        this.legajoPersonaAsignada = personaAsignada;
    }

}
