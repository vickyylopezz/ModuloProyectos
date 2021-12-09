package com.aninfo.repository;

import com.aninfo.model.Tarea;
import java.util.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TareaRepository extends CrudRepository<Tarea, Long> {

    Collection<Tarea> getTareasByCodigoProyecto(long codigoProyecto);

    Tarea findTareaByCodigoTarea(Long codigoTarea);

    Iterable<Tarea> findAllByCodigoProyecto(Long codigoProyecto);

    Iterable<Tarea> findAllByNombre(String nombreTarea);

    Iterable<Tarea> findAllByEstado(String estado);

    Iterable<Tarea> findAllByPersonaAsignada(String empleado);
}
