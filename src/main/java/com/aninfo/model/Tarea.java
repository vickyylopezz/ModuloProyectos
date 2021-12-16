package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tarea_id")
    private Long id;

    @Column(name = "tarea_id_proyecto")
    private Long codigoProyecto;

    @Column(name = "tarea_nombre")
    private String nombre;

    @Column(name = "tarea_estado")
    private String estado = "CREADA";

    @Column(name = "tarea_descripcion")
    private String descripcion;

    @Column(name = "tarea_legajo_empleado")
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
