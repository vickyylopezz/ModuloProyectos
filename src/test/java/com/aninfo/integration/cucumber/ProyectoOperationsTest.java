package com.aninfo.integration.cucumber;

import com.aninfo.exceptions.ProyectoFinalizadoException;
import com.aninfo.model.Proyecto;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class ProyectoOperationsTest extends ProyectoIntegrationServiceTest {

    private Proyecto proyecto;
    private String nombreProyecto;
    private String liderProyecto;
    private String descripcion;
    private String estado;
    private Iterable<Proyecto> proyectosObtenidos;
    private ProyectoFinalizadoException proyectoFinalizado;

    @Given("^Que se quiere crear un proyecto$")
    public void queSeQuiereCrearUnProyecto() {
        this.nombreProyecto = "Proyecto A";
        this.liderProyecto = "Carlos Zarate";
        this.descripcion = "Desarrollo de nueva API de Psa";
    }

    @When("^Creo un proyecto$")
    public void creoUnProyecto() {
        proyecto = crearProyecto(nombreProyecto, liderProyecto,descripcion);
    }

    @Then("^Se carga el proyecto en el sistema con los datos correspondientes$")
    public void seCargaElProyectoEnElSistemaConLosDatosCorrespondientes() {
        assertEquals(this.nombreProyecto, proyecto.getNombre());
        assertEquals(this.liderProyecto, proyecto.getLiderDeProyecto());
        assertEquals("CREADO", proyecto.getEstado());
        assertEquals(this.descripcion, proyecto.getDescripcion());
        eliminarTodosLosProyectos();
    }

    @Given("^Que se quiere eliminar un proyecto$")
    public void queSeQuiereEliminarUnProyecto() {
        this.nombreProyecto = "Proyecto A";
        this.liderProyecto = "Carlos Zarate";
        this.descripcion = "Desarrollo de nueva API de Psa";
        proyecto = crearProyecto(nombreProyecto, liderProyecto,descripcion);
    }

    @Given("^Que se quiere eliminar un proyecto finalizado$")
    public void queSeQuiereEliminarUnProyectoFinalizado() {
        this.nombreProyecto = "Proyecto A";
        this.liderProyecto = "Carlos Zarate";
        this.descripcion = "Desarrollo de nueva API de Psa";
        proyecto = crearProyecto(nombreProyecto, liderProyecto,descripcion);
        proyecto = modificarProyecto(proyecto.getId(),proyecto.getNombre(),proyecto.getLiderDeProyecto(), proyecto.getDescripcion(), "FINALIZADO");
    }

    @When("^Elimino un proyecto$")
    public void eliminoUnProyecto() {
        try {
            eliminarProyecto(proyecto.getId());

        } catch (ProyectoFinalizadoException proyectoFinalizado) {
            this.proyectoFinalizado = proyectoFinalizado;
        }
    }

    @Then("^Se eliminara el proyecto del sistema$")
    public void seEliminaraElProyectoDelSistema() {
        assertEquals(false, existeProyecto(proyecto.getId()));
        eliminarTodosLosProyectos();
    }

    @Then("^No se eliminara el proyecto del sistema$")
    public void noSeEliminaraElProyectoDelSistema() {
        assertNotNull(proyectoFinalizado);
        proyectoFinalizado = null;
        eliminarTodosLosProyectos();
    }

    @Given("^Que se quiere editar un proyecto$")
    public void queSeQuiereEditarUnProyecto() {
        this.nombreProyecto = "Proyecto A";
        this.liderProyecto = "Carlos Zarate";
        this.descripcion = "Desarrollo de nueva API de Psa";
        proyecto = crearProyecto(nombreProyecto, liderProyecto,descripcion);
    }

    @Given("^Que se quiere editar un proyecto finalizado$")
    public void queSeQuiereEditarUnProyectoFinalizado() {
        this.nombreProyecto = "Proyecto A";
        this.liderProyecto = "Carlos Zarate";
        this.descripcion = "Desarrollo de nueva API de Psa";
        proyecto = crearProyecto(nombreProyecto, liderProyecto,descripcion);
        proyecto = modificarProyecto(proyecto.getId(),proyecto.getNombre(),proyecto.getLiderDeProyecto(), proyecto.getDescripcion(), "FINALIZADO");
    }

    @When("^Edito el proyecto$")
    public void editoElProyecto() {
        nombreProyecto = "ProyectoB";
        liderProyecto = "Claudia Suarez";
        estado = "ENCURSO";

        try{
            proyecto = modificarProyecto(proyecto.getId(), nombreProyecto, liderProyecto, proyecto.getDescripcion(), estado);
        } catch (ProyectoFinalizadoException proyectoFinalizado){
            this.proyectoFinalizado = proyectoFinalizado;
        }
    }

    @Then("^Se me actualizara la informacion del mismo$")
    public void seMeActualizaraLaInformacionDelMismo() {
        assertEquals(this.nombreProyecto, proyecto.getNombre());
        assertEquals(this.estado, proyecto.getEstado());
        assertEquals(this.liderProyecto, proyecto.getLiderDeProyecto());
        assertEquals(descripcion, proyecto.getDescripcion());
        eliminarTodosLosProyectos();
    }

    @Then("^No se me actualizara la informacion del mismo$")
    public void noSeMeActualizaraLaInformacionDelMismo() {
        assertNotNull(proyectoFinalizado);
        proyectoFinalizado = null;
        eliminarTodosLosProyectos();
    }


    @Given("^Que se quiere filtrar los proyectos por nombre$")
    public void queSeQuiereFiltrarLosProyectosPorNombre() {
        crearProyecto("ProyectoA", "Carlos","Descripcion1");
        crearProyecto("ProyectoA", "Marcela","Descripcion2");
        crearProyecto("ProyectoA", "Juana","Descripcion3");
        crearProyecto("ProyectoB", "Claudio","Descripcion4");
        crearProyecto("ProyectoC", "Juan","Descripcion5");
    }

    @When("^Hago el filtrado por nombre$")
    public void hagoElFiltradoPorNombre() {
        proyectosObtenidos = obtenerTodosLosProyectosConNombre("ProyectoA");
    }

    @Then("^Se me mostraran solo los proyectos pedidos$")
    public void seMeMostraranSoloLosProyectosPedidos() {
        assertEquals(proyectosObtenidos.spliterator().getExactSizeIfKnown(),3);
        eliminarTodosLosProyectos();
    }

    @Given("^Que se quiere filtrar los proyectos por estado$")
    public void queSeQuiereFiltrarLosProyectosPorEstado() {
        proyecto = crearProyecto("ProyectoA", "Carlos","Descripcion1");
        proyecto = modificarProyecto(proyecto.getId(),proyecto.getNombre(),proyecto.getLiderDeProyecto(),proyecto.getDescripcion(),"ENCURSO");
        proyecto = crearProyecto("ProyectoA", "Marcela","Descripcion2");
        proyecto = modificarProyecto(proyecto.getId(),proyecto.getNombre(),proyecto.getLiderDeProyecto(),proyecto.getDescripcion(),"ENCURSO");
        proyecto = crearProyecto("ProyectoA", "Juana","Descripcion3");
        proyecto = modificarProyecto(proyecto.getId(),proyecto.getNombre(),proyecto.getLiderDeProyecto(),proyecto.getDescripcion(),"FINALIZADO");
        crearProyecto("ProyectoB", "Claudio","Descripcion4");
        crearProyecto("ProyectoC", "Juan","Descripcion5");
    }

    @When("^Hago el filtrado por estado en curso$")
    public void hagoElFiltradoPorEstadoEnCurso() {
        proyectosObtenidos = obtenerTodosLosProyectosConEstado("ENCURSO");
    }

    @Then("^Se me mostraran solo los proyectos con estado en curso$")
    public void seMeMostraranSoloLosProyectosConEstadoEnCurso() {
        assertEquals(proyectosObtenidos.spliterator().getExactSizeIfKnown(),2);
        eliminarTodosLosProyectos();

    }

    @When("^Hago el filtrado por estado finalizado$")
    public void hagoElFiltradoPorEstadoFinalizado() {
        proyectosObtenidos = obtenerTodosLosProyectosConEstado("FINALIZADO");
    }

    @Then("^Se me mostraran solo los proyectos con estado finalizado$")
    public void seMeMostraranSoloLosProyectosConEstadoFinalizado() {
        assertEquals(proyectosObtenidos.spliterator().getExactSizeIfKnown(),1);
        eliminarTodosLosProyectos();
    }

    @Given("^Que se quiere filtrar los proyectos por lider$")
    public void queSeQuiereFiltrarLosProyectosPorLider() {
        crearProyecto("ProyectoA", "Carlos","Descripcion1");
        crearProyecto("ProyectoA", "Carlos","Descripcion2");
        crearProyecto("ProyectoA", "Juana","Descripcion3");
        crearProyecto("ProyectoB", "Claudio","Descripcion4");
        crearProyecto("ProyectoC", "Carlos","Descripcion5");
    }

    @When("^Hago el filtrado por lider$")
    public void hagoElFiltradoPorLider() {
        proyectosObtenidos = obtenerTodosLosProyectosConLider("Carlos");

    }

    @Then("^Se me mostraran solo los proyectos con el lider elegido$")
    public void seMeMostraranSoloLosProyectosConElLiderElegido() {
        assertEquals(proyectosObtenidos.spliterator().getExactSizeIfKnown(),3);
        eliminarTodosLosProyectos();
    }



}
