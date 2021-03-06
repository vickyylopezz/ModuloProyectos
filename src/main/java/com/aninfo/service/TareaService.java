package com.aninfo.service;

import com.aninfo.exceptions.TareaFinalizadaException;
import com.aninfo.model.Tarea;
import com.aninfo.repository.ProyectoRepository;
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

    private ProyectoRepository proyectoRepository;

    public Collection<Tarea> getTareas(long codigoProyecto) {
        return tareaRepository.getTareasByCodigoProyecto(codigoProyecto);
    }

    public Tarea crearTarea(Tarea tarea) {

        return tareaRepository.save(tarea);
    }

    public void deleteById(Long codigoTarea) {
        Tarea tarea = tareaRepository.findTareaById(codigoTarea);

        if(tarea.getEstado().equals("FINALIZADA")){
            throw new TareaFinalizadaException("No se puede eliminar una tarea finalizada");
        }
        tareaRepository.deleteById(codigoTarea);
    }

    @Transactional
    public void deleteByCodigoProyecto(Long codigoProyecto) {

        tareaRepository.deleteAllByCodigoProyecto(codigoProyecto);
    }

    public Optional<Tarea> findById(Long codigoTarea) {
        return tareaRepository.findById(codigoTarea);
    }

    public void save(Tarea tarea) {
        tareaRepository.save(tarea);
    }


    public void deleteAll() { tareaRepository.deleteAll();
    }

    public boolean existeTarea(Long codigoTarea) { return tareaRepository.existsById(codigoTarea);
    }

    public Tarea modificarTarea(Long codigoTarea, Long codigoProyecto, String nombreTarea, String descripcion, Integer personaAsignada, String estado) {
        Tarea tarea = tareaRepository.findTareaById(codigoTarea);

        if(tarea.getEstado().equals("FINALIZADA")){
            throw new TareaFinalizadaException("No se puede modificar una tarea finalizada");
        }

        tarea.setCodigoProyecto(codigoProyecto);
        tarea.setNombre(nombreTarea);
        tarea.setDescripcion(descripcion);
        tarea.setLegajoPersonaAsignada(personaAsignada);
        tarea.setEstado(estado);
        tareaRepository.deleteById(tarea.getId());

        return tareaRepository.save(tarea);
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

    public Iterable<Tarea> obtenerTodasLasTareasConEmpleado(Integer empleado) {
        return tareaRepository.findAllByLegajoPersonaAsignada(empleado);

    }
}
