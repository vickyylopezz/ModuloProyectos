package com.aninfo.integration.cucumber;

import com.aninfo.ProyectosApp;
import com.aninfo.model.Estado;
import com.aninfo.model.Proyecto;
import com.aninfo.service.ProyectoService;
import gherkin.lexer.Es;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
import java.util.Optional;

@ContextConfiguration(classes = ProyectosApp.class)
@WebAppConfiguration
public class ProyectoIntegrationServiceTest {

    @Autowired
    ProyectoService proyectoService;

    Proyecto crearProyecto(String nombre,
                           String liderDeProyecto,
                           String fechaCreacion, String descripcion) {
        return proyectoService.crearProyecto(new Proyecto(nombre, liderDeProyecto, fechaCreacion, descripcion));
    }

    void eliminarProyecto(Long codigoProyecto){
        proyectoService.deleteById(codigoProyecto);
    }

    Optional<Proyecto> buscarProyectoPorCodigo(Long codigoProyecto){
        return proyectoService.findById(codigoProyecto);
    }

    Proyecto modificarProyecto(Long codigoProyecto, String nombre, String liderDeProyecto, String fechaCreacion, String descripcion, Estado estado){
        return proyectoService.modificarProyecto(codigoProyecto,nombre,liderDeProyecto,fechaCreacion,descripcion,estado);
    }

}
