package com.aninfo.model;

import org.hibernate.boot.model.source.spi.IdentifierSource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoTarea;

    private Long codigoProyecto;
    private String nombre;
    private Estado estado;
    private String descripcion;
    private String personaAsignada;

    public Tarea() {
    }

    public Tarea(Long codigoProyecto, String nombre, Estado estado, String descripcion, String personaAsignada) {
        this.codigoProyecto = codigoProyecto;
        this.nombre = nombre;
        this.estado = estado;
        this.descripcion = descripcion;
        this.personaAsignada = personaAsignada;
    }

    public Long getCodigoTarea() {
        return codigoTarea;
    }

    public void setCodigoTarea(Long codigoTarea) {
        this.codigoTarea = codigoTarea;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPersonaAsignada() {
        return personaAsignada;
    }

    public void setPersonaAsignada(String personaAsignada) {
        this.personaAsignada = personaAsignada;
    }

}
