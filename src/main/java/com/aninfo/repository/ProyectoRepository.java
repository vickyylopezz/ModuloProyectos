package com.aninfo.repository;

import com.aninfo.model.Estado;
import com.aninfo.model.Proyecto;
import com.aninfo.model.Tarea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface ProyectoRepository extends CrudRepository<Proyecto, Long> {

    Proyecto findProyectoByCodigo(Long codigo);
}
