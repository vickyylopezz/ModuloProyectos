package com.aninfo.integration.cucumber;

import com.aninfo.model.Tarea;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TareaOperationsTest extends TareaIntegrationServiceTest{

    private Tarea tarea;
    private String nombreTarea;
    private Long codigoProyecto;
    private String descripcion;
    private String personaAsignada;
    private String estado;
    private Iterable<Tarea> tareasObtenidas;

    @Given("^Que se quiere crear una tarea$")
    public void queSeQuiereCrearUnaTarea() {
        this.nombreTarea = "Tarea A";
        this.codigoProyecto = 1L;
        this.descripcion = "Descripcion 1";
        this.personaAsignada = "Marcos Cesar";
    }

    @When("^Creo una tarea$")
    public void creoUnaTarea() {
        tarea = crearTarea(codigoProyecto, nombreTarea, descripcion, personaAsignada);
    }

    @Then("^Se carga la tarea en el sistema con los datos correspondientes$")
    public void seCargaLaTareaEnElSistemaConLosDatosCorrespondientes() {
        assertEquals(this.nombreTarea, tarea.getNombre());
        assertEquals(this.codigoProyecto, tarea.getCodigoProyecto());
        assertEquals("CREADA", tarea.getEstado());
        assertEquals(this.descripcion, tarea.getDescripcion());
        assertEquals(this.personaAsignada, tarea.getPersonaAsignada());
        eliminarTodasLasTareas();
    }


    @Given("^Que se quiere eliminar una tarea$")
    public void queSeQuiereEliminarUnaTarea() {
        this.nombreTarea = "Tarea A";
        this.codigoProyecto = 1L;
        this.descripcion = "Descripcion 1";
        this.personaAsignada = "Marcos Cesar";
        tarea = crearTarea(codigoProyecto , nombreTarea, descripcion, personaAsignada);
    }

    @When("^Elimino una tarea$")
    public void eliminoUnaTarea() {
        eliminarTarea(tarea.getCodigoTarea());
    }

    @Then("^Se eliminara la tarea del sistema$")
    public void seEliminaraLaTareaDelSistema() {
        assertFalse(existeTarea(tarea.getCodigoTarea()));
    }

    @Given("^Que se quiere editar una tarea$")
    public void queSeQuiereEditarUnaTarea() {
        this.nombreTarea = "Tarea A";
        this.codigoProyecto = 1L;
        this.descripcion = "Descripcion 1";
        this.personaAsignada = "Marcos Cesar";
        tarea = crearTarea(codigoProyecto , nombreTarea, descripcion, personaAsignada);
    }

    @When("^Edito la tarea$")
    public void editoLaTarea() {
        nombreTarea = "Tarea A2";
        estado = "ENCURSO";
        tarea = modificarTarea(tarea.getCodigoTarea(),codigoProyecto , nombreTarea, descripcion, personaAsignada, estado);
    }

    @Then("^Se me actualizara la informacion de la misma$")
    public void seMeActualizaraLaInformacionDeLaMisma() {
        assertEquals(this.codigoProyecto, tarea.getCodigoProyecto());
        assertEquals(this.nombreTarea, tarea.getNombre());
        assertEquals(descripcion, tarea.getDescripcion());
        assertEquals(this.personaAsignada, tarea.getPersonaAsignada());
        assertEquals(this.estado, tarea.getEstado());
        eliminarTodasLasTareas();
    }

    @Given("^Que se quiere agregar tareas a un mismo proyecto$")
    public void queSeQuiereAgregarTareasAUnMismoProyecto() {
        crearTarea(15L, "Tarea A", "Descripcio 1", "Marta");
        crearTarea(15L, "Tarea B", "Descripcio 2", "Carlos");
        crearTarea(15L, "Tarea C", "Descripcio 3", "Manuela");
        crearTarea(13L, "Tarea D", "Descripcio 4", "Lorena");
    }

    @When("^Agrego las tareas$")
    public void agregoLasTareas() {
        tareasObtenidas = obtenerTodasLasTareasDelProyecto(Long.valueOf(15));
    }



    @Then("^Las tareas deben pertenecer al proyecto$")
    public void lasTareasDebenPertenecerAlProyecto() {
        assertEquals(3, tareasObtenidas.spliterator().getExactSizeIfKnown());
    }
}
