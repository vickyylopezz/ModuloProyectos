package com.aninfo.integration.cucumber;

import com.aninfo.exceptions.TareaFinalizadaException;
import com.aninfo.model.Tarea;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class TareaOperationsTest extends TareaIntegrationServiceTest{

    private Tarea tarea;
    private String nombreTarea;
    private Long codigoProyecto;
    private String descripcion;
    private Integer personaAsignada;
    private String estado;
    private Iterable<Tarea> tareasObtenidas;
    private TareaFinalizadaException tareaFinalizada;

    @Given("^Que se quiere crear una tarea$")
    public void queSeQuiereCrearUnaTarea() {
        this.nombreTarea = "Tarea A";
        this.codigoProyecto = 1L;
        this.descripcion = "Descripcion 1";
        this.personaAsignada = 34;
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
        assertEquals(this.personaAsignada, tarea.getLegajoPersonaAsignada());
        eliminarTodasLasTareas();
    }


    @Given("^Que se quiere eliminar una tarea$")
    public void queSeQuiereEliminarUnaTarea() {
        this.nombreTarea = "Tarea A";
        this.codigoProyecto = 1L;
        this.descripcion = "Descripcion 1";
        this.personaAsignada = 34;
        tarea = crearTarea(codigoProyecto , nombreTarea, descripcion, personaAsignada);
    }

    @Given("^Que se quiere eliminar una tarea finalizada$")
    public void queSeQuiereEliminarUnaTareaFinalizada() {
        this.nombreTarea = "Tarea A";
        this.codigoProyecto = 1L;
        this.descripcion = "Descripcion 1";
        this.personaAsignada = 34;
        tarea = crearTarea(codigoProyecto , nombreTarea, descripcion, personaAsignada);
        tarea = modificarTarea(tarea.getId(),tarea.getCodigoProyecto() , tarea.getNombre(), tarea.getDescripcion(), tarea.getLegajoPersonaAsignada(), "FINALIZADA");

    }

    @When("^Elimino una tarea$")
    public void eliminoUnaTarea() {
        try{
            eliminarTarea(tarea.getId());
        } catch (TareaFinalizadaException tareaFinalizada){
            this.tareaFinalizada = tareaFinalizada;
        }
    }

    @Then("^Se eliminara la tarea del sistema$")
    public void seEliminaraLaTareaDelSistema() {
        assertFalse(existeTarea(tarea.getId()));
    }

    @Then("^No se eliminara la tarea del sistema$")
    public void noSeEliminaraLaTareaDelSistema() {
        assertNotNull(tareaFinalizada);
        tareaFinalizada = null;
        eliminarTodasLasTareas();
    }

    @Given("^Que se quiere editar una tarea$")
    public void queSeQuiereEditarUnaTarea() {
        this.nombreTarea = "Tarea A";
        this.codigoProyecto = 1L;
        this.descripcion = "Descripcion 1";
        this.personaAsignada = 34;
        tarea = crearTarea(codigoProyecto , nombreTarea, descripcion, personaAsignada);
    }

    @Given("^Que se quiere editar una tarea finalizada$")
    public void queSeQuiereEditarUnaTareaFinalizada() {
        this.nombreTarea = "Tarea A";
        this.codigoProyecto = 1L;
        this.descripcion = "Descripcion 1";
        this.personaAsignada = 34;
        tarea = crearTarea(codigoProyecto , nombreTarea, descripcion, personaAsignada);
        tarea = modificarTarea(tarea.getId(),tarea.getCodigoProyecto() , tarea.getNombre(), tarea.getDescripcion(), tarea.getLegajoPersonaAsignada(), "FINALIZADA");
    }

    @When("^Edito la tarea$")
    public void editoLaTarea() {
        nombreTarea = "Tarea A2";
        estado = "ENCURSO";
        try {
            tarea = modificarTarea(tarea.getId(),codigoProyecto , nombreTarea, descripcion, personaAsignada, estado);
        } catch(TareaFinalizadaException tareaFinalizada){
            this.tareaFinalizada = tareaFinalizada;
        }
    }

    @Then("^Se me actualizara la informacion de la misma$")
    public void seMeActualizaraLaInformacionDeLaMisma() {
        assertEquals(this.codigoProyecto, tarea.getCodigoProyecto());
        assertEquals(this.nombreTarea, tarea.getNombre());
        assertEquals(descripcion, tarea.getDescripcion());
        assertEquals(this.personaAsignada, tarea.getLegajoPersonaAsignada());
        assertEquals(this.estado, tarea.getEstado());
        eliminarTodasLasTareas();
    }

    @Then("^No se me actualizara la informacion de la misma$")
    public void noSeMeActualizaraLaInformacionDeLaMisma() {
        assertNotNull(tareaFinalizada);
        tareaFinalizada = null;
        eliminarTodasLasTareas();
    }

    @Given("^Que se quiere agregar tareas a un mismo proyecto$")
    public void queSeQuiereAgregarTareasAUnMismoProyecto() {
        crearTarea(15L, "Tarea A", "Descripcio 1", 23);
        crearTarea(15L, "Tarea B", "Descripcio 2", 13);
        crearTarea(15L, "Tarea C", "Descripcio 3", 4);
        crearTarea(13L, "Tarea D", "Descripcio 4", 5);
    }

    @When("^Agrego las tareas$")
    public void agregoLasTareas() {
        tareasObtenidas = obtenerTodasLasTareasDelProyecto(15L);
    }

    @Then("^Las tareas deben pertenecer al proyecto$")
    public void lasTareasDebenPertenecerAlProyecto() {
        assertEquals(3, tareasObtenidas.spliterator().getExactSizeIfKnown());
        eliminarTodasLasTareas();
    }

    @Given("^Que se quiere filtrar las tareas por nombre$")
    public void queSeQuiereFiltrarLasTareasPorNombre() {
        crearTarea(15L, "Tarea A", "Descripcio 1", 24);
        crearTarea(16L, "Tarea A", "Descripcio 2", 12);
        crearTarea(15L, "Tarea B", "Descripcio 3", 47);
        crearTarea(13L, "Tarea A", "Descripcio 4", 9);
    }

    @When("^Hago el filtrado de tareas por nombre$")
    public void hagoElFiltradoPorNombre() {
        tareasObtenidas = obtenerTodasLasTareasConNombre("Tarea A");
    }

    @Then("^Se me mostraran solo las tareas pedidas$")
    public void seMeMostraranSoloLasTareasPedidas() {
        assertEquals(tareasObtenidas.spliterator().getExactSizeIfKnown(),3);
        eliminarTodasLasTareas();
    }

    @Given("^Que se quiere filtrar las tareas por estado$")
    public void queSeQuiereFiltrarLasTareasPorEstado() {
        tarea = crearTarea(15L, "Tarea A", "Descripcio 1", 12);
        tarea = modificarTarea(tarea.getId(),tarea.getCodigoProyecto(),tarea.getNombre(),tarea.getDescripcion(),tarea.getLegajoPersonaAsignada(),"FINALIZADA");
        tarea = crearTarea(16L, "Tarea A", "Descripcio 2", 13);
        tarea = modificarTarea(tarea.getId(),tarea.getCodigoProyecto(),tarea.getNombre(),tarea.getDescripcion(),tarea.getLegajoPersonaAsignada(),"ENCURSO");
        tarea = crearTarea(15L, "Tarea B", "Descripcio 3", 14);
        tarea = modificarTarea(tarea.getId(),tarea.getCodigoProyecto(),tarea.getNombre(),tarea.getDescripcion(),tarea.getLegajoPersonaAsignada(),"ENCURSO");
        crearTarea(13L, "Tarea A", "Descripcio 4", 15);
    }

    @When("^Hago el filtrado de tareas por estado en curso$")
    public void hagoElFiltradoDeTareasPorEstadoEnCurso() {
        tareasObtenidas = obtenerTodasLasTareasConEstado("ENCURSO");
    }

    @Then("^Se me mostraran solo las tareas con estado en curso$")
    public void seMeMostraranSoloLasTareasConEstadoEnCurso() {
        assertEquals(tareasObtenidas.spliterator().getExactSizeIfKnown(),2);
        eliminarTodasLasTareas();
    }

    @When("^Hago el filtrado de tareas por estado finalizada$")
    public void hagoElFiltradoDeTareasPorEstadoFinalizada() {
        tareasObtenidas = obtenerTodasLasTareasConEstado("FINALIZADA");
    }

    @Then("^Se me mostraran solo las tareas con estado finalizada$")
    public void seMeMostraranSoloLasTareasConEstadoFinalizada() {
        assertEquals(tareasObtenidas.spliterator().getExactSizeIfKnown(),1);
        eliminarTodasLasTareas();
    }

    @Given("^Que se quiere filtrar las tareas por empleado asignado$")
    public void queSeQuiereFiltrarLasTareasPorEmpleadoAsignado() {
        crearTarea(15L, "Tarea A", "Descripcio 1", 11);
        crearTarea(16L, "Tarea A", "Descripcio 2", 13);
        crearTarea(15L, "Tarea B", "Descripcio 3", 11);
        crearTarea(13L, "Tarea A", "Descripcio 4", 21);
    }

    @When("^Hago el filtrado de tareas por empleado asignado$")
    public void hagoElFiltradoDeTareasPorEmpleadoAsignado() {
        tareasObtenidas = obtenerTodasLasTareasConEmpleadoAsignado(11);
    }



    @Then("^Se me mostraran solo las tareas con el empleado asignado elegido$")
    public void seMeMostraranSoloLasTareasConElEmpleadoAsignadoElegido() {
        assertEquals(tareasObtenidas.spliterator().getExactSizeIfKnown(),2);
        eliminarTodasLasTareas();
    }



}
