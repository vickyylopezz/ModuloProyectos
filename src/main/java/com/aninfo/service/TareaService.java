package com.aninfo.service;

import com.aninfo.model.Proyecto;
import com.aninfo.model.Tarea;
import com.aninfo.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Component
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;


    public Collection<Tarea> getTareas(long codigoProyecto) {
        return tareaRepository.getTareasByCodigoProyecto(codigoProyecto);
    }

    public Tarea crearTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public void deleteById(Long codigoTarea) {
        tareaRepository.deleteById(codigoTarea);
    }

    public Optional<Tarea> findById(Long codigoTarea) {
        return tareaRepository.findById(codigoTarea);
    }

    public void save(Tarea tarea) {
        tareaRepository.save(tarea);
    }


    public void deleteAll() { tareaRepository.deleteAll();
    }

    public boolean existeProyecto(Long codigoTarea) { return tareaRepository.existsById(codigoTarea);
    }

    public Tarea modificarTarea(Long codigoTarea, Long codigoProyecto, String nombreTarea, String descripcion, String personaAsignada, String estado) {
        Tarea tarea = tareaRepository.findTareaByCodigoTarea(codigoTarea);
        tarea.setCodigoProyecto(codigoProyecto);
        tarea.setNombre(nombreTarea);
        tarea.setDescripcion(descripcion);
        tarea.setPersonaAsignada(personaAsignada);
        tarea.setEstado(estado);
        tareaRepository.delete(tarea);
        tareaRepository.save(tarea);
        return tarea;
    }

    public Iterable<Tarea> obtenerTodasLasTareasConConCodigoProyecto(Long codigoProyecto) {
        return tareaRepository.findAllByCodigoProyecto(codigoProyecto);
    }

    public Iterable<Tarea> obtenerTodasLasTareasConNombre(String nombreTarea) {
        return tareaRepository.findAllByNombre(nombreTarea);
    }

    public Iterable<Tarea> obtenerTodasLasTareasConEstado(String estado) {
        return tareaRepository.findAllByEstado(estado);
    }

    public Iterable<Tarea> obtenerTodasLasTareasConEmpleado(String empleado) {
        return tareaRepository.findAllByPersonaAsignada(empleado);

    }
}
