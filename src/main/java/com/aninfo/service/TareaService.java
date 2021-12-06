package com.aninfo.service;

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

    public Tarea createTarea(Tarea tarea) {
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
}
