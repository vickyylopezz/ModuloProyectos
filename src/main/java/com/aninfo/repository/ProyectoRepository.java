package com.aninfo.repository;

import com.aninfo.model.Proyecto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProyectoRepository extends CrudRepository<Proyecto, Long> {

    Proyecto findProyectoById(Long codigo);

    Iterable<Proyecto> findAllByNombre(String nombre);

    Iterable<Proyecto> findAllByEstado(String estado);

    Iterable<Proyecto> findAllByLiderDeProyecto(String lider);
}
