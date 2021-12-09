package com.aninfo.integration.cucumber;

import com.aninfo.ProyectosApp;
import com.aninfo.model.Proyecto;
import com.aninfo.model.Tarea;
import com.aninfo.service.ProyectoService;
import com.aninfo.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = ProyectosApp.class)
@WebAppConfiguration
public class TareaIntegrationServiceTest {

    @Autowired
    TareaService tareaService;

    Tarea crearTarea(Long codigoProyecto, String nombre, String descripcion, String personaAsignada) {
        return tareaService.crearTarea(new Tarea(codigoProyecto, nombre, descripcion, personaAsignada));
    }

    void eliminarTodasLasTareas() { tareaService.deleteAll();
    }

    void eliminarTarea(Long codigoTarea) { tareaService.deleteById(codigoTarea);
    }

    boolean existeTarea(Long codigoTarea) { return tareaService.existeProyecto(codigoTarea);
    }

    Tarea modificarTarea(Long codigoTarea, Long codigoProyecto, String nombreTarea, String descripcion, String personaAsignada, String estado) {
        return tareaService.modificarTarea(codigoTarea, codigoProyecto,nombreTarea,descripcion,personaAsignada,estado);
    }

    Iterable<Tarea> obtenerTodasLasTareasDelProyecto(Long codigoProyecto) {
        return tareaService.obtenerTodasLasTareasConConCodigoProyecto(codigoProyecto);
    }
}
