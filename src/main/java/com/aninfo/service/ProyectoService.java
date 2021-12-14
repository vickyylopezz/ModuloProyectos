package com.aninfo.service;

import com.aninfo.exceptions.ProyectoFinalizadoException;
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
        Proyecto proyecto = proyectoRepository.findProyectoById(codigo);
        if(proyecto.getEstado().equals("FINALIZADO")){
            throw new ProyectoFinalizadoException("No se puede eliminar un proyecto finalizado");
        }
        proyectoRepository.deleteById(codigo);
    }

    public Proyecto modificarProyecto(Long codigoProyecto, String nombre, String liderDeProyecto, String descripcion, String estado) {
        Proyecto proyecto = proyectoRepository.findProyectoById(codigoProyecto);

        if(proyecto.getEstado().equals("FINALIZADO")){
            throw new ProyectoFinalizadoException("No se puede modificar un proyecto finalizado");
        }

        proyecto.setNombre(nombre);
        proyecto.setLiderDeProyecto(liderDeProyecto);
        proyecto.setDescripcion(descripcion);
        proyecto.setEstado(estado);
        proyectoRepository.deleteById(proyecto.getId());

        return proyectoRepository.save(proyecto);
    }

    public Boolean existeProyecto(Long codigo){
        return proyectoRepository.existsById(codigo);
    }

    public Iterable<Proyecto> obtenerTodosLosProyectosConNombre(String nombre) {
        return proyectoRepository.findAllByNombre(nombre);
    }

    public Iterable<Proyecto> obtenerTodosLosProyectosConEstado(String estado) {
        return proyectoRepository.findAllByEstado(estado);
    }

    public void deleteAll() {
        proyectoRepository.deleteAll();
    }

    public Iterable<Proyecto> obtenerTodosLosProyectosConLider(String lider) {
        return proyectoRepository.findAllByLiderDeProyecto(lider);
    }

    public boolean proyectoFinalizado(Long codigo){
        return proyectoRepository.findProyectoById(codigo).getEstado().equals("FINALIZADO");

    }
}
