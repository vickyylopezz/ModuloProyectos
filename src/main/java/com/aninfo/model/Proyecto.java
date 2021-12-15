package com.aninfo.model;

import jdk.jfr.SettingDefinition;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private Integer legajoLider;

    private String estado = "CREADO";
    private String fechaCreacion = todayDate();
    private String descripcion;

    protected Proyecto() {
    }

    public String todayDate() {

            SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar calendar = Calendar.getInstance();

            Date dateObj = calendar.getTime();
            return dtf.format(dateObj);
    }

    public Proyecto(String nombre, Integer liderDeProyecto, String descripcion) {
        this.nombre = nombre;
        this.legajoLider = liderDeProyecto;
        this.estado = "CREADO";
        this.descripcion = descripcion;
        this.fechaCreacion = todayDate();
    }

    public Long getId() { return id; }

    public void setId(Long codigo) { this.id = codigo; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setLiderDeProyecto(Integer liderDeProyecto){
        this.legajoLider = liderDeProyecto;
    }

    public Integer getLiderDeProyecto(){
        return legajoLider;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public String getEstado(){
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

