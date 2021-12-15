package com.aninfo.integration.cucumber;

import com.aninfo.ProyectosApp;
import com.aninfo.model.Proyecto;
import com.aninfo.service.ProyectoService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Optional;

@ContextConfiguration(classes = ProyectosApp.class)
@WebAppConfiguration
public class ProyectoIntegrationServiceTest {

    @Autowired
    ProyectoService proyectoService;

    Proyecto crearProyecto(String nombre,
                           Integer liderDeProyecto,
                           String descripcion) {
        return proyectoService.crearProyecto(new Proyecto(nombre, liderDeProyecto, descripcion));
    }

    void eliminarProyecto(Long codigoProyecto){
        proyectoService.deleteById(codigoProyecto);
    }

    Proyecto modificarProyecto(Long codigoProyecto, String nombre, Integer liderDeProyecto, String descripcion, String estado){
        return proyectoService.modificarProyecto(codigoProyecto,nombre,liderDeProyecto,descripcion,estado);
    }

    Boolean existeProyecto(Long codigo){
        return proyectoService.existeProyecto(codigo);
    }

    Iterable<Proyecto> obtenerTodosLosProyectosConNombre(String nombre){
        return proyectoService.obtenerTodosLosProyectosConNombre(nombre);
    }

    Iterable<Proyecto> obtenerTodosLosProyectosConEstado(String estado) {
        return proyectoService.obtenerTodosLosProyectosConEstado(estado);
    }

    void eliminarTodosLosProyectos(){
        proyectoService.deleteAll();
    }

    Iterable<Proyecto> obtenerTodosLosProyectosConLider(Integer lider) {
        return proyectoService.obtenerTodosLosProyectosConLider(lider);
    }
}
