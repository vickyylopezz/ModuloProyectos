package com.aninfo.service;

import com.aninfo.model.Estado;
import com.aninfo.model.Proyecto;
import com.aninfo.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    public Proyecto crearProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public Collection<Proyecto> getProyectos() {
        Collection<Proyecto> proyectos = new ArrayList<>();
        proyectoRepository.findAll().forEach(proyectos::add);
        return proyectos;
    }

    public Optional<Proyecto> findById(Long codigo) {
        return proyectoRepository.findById(codigo);
    }

    public void save(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }

    public void deleteById(Long codigo) {
        proyectoRepository.deleteById(codigo);
    }

    public Proyecto modificarProyecto(Long codigoProyecto, String nombre, String liderDeProyecto, String fechaCreacion, String descripcion, Estado estado) {
        Proyecto proyecto = proyectoRepository.findProyectoByCodigo(codigoProyecto);
        proyecto.setNombre(nombre);
        proyecto.setLiderDeProyecto(liderDeProyecto);
        proyecto.setFechaCreacion(fechaCreacion);
        proyecto.setDescripcion(descripcion);
        proyecto.setEstado(estado);

        return proyecto;
    }
}
