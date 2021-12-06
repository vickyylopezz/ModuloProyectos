package com.aninfo.integration.cucumber;

import com.aninfo.model.Estado;
import com.aninfo.model.Proyecto;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProyectoOperationsTest extends ProyectoIntegrationServiceTest {

    private Proyecto proyecto;
    private String nombreProyecto;
    private String liderProyecto;
    private String fechaCreacion;
    private String descripcion;

    @Given("^Que se quiere crear un proyecto con nombre (.*), lider (.*), fecha (.*) y descripcion: (.*)$")
    public void setDatosProyecto(String nombre, String lider, String fechaCreacion, String descripcion){
        this.nombreProyecto = nombre;
        this.liderProyecto = lider;
        this.fechaCreacion = fechaCreacion;
        this.descripcion = descripcion;
    }

    @When("^Creo un proyecto$")
    public void creoProyecto()  {
        proyecto = crearProyecto(nombreProyecto, liderProyecto, fechaCreacion,descripcion);
    }

    @Then("^Se carga en el sistema con los datos correspondientes, (.*), (.*), (.*), (.*)$")
    public void comparacionDatosProyecto(String nombreIngresado, String liderIngresado, String fechaIngresada, String descripcionIngresada){
        assertEquals(nombreIngresado, proyecto.getNombre());
        assertEquals(liderIngresado, proyecto.getLiderDeProyecto());
        assertEquals(Estado.CREADO, proyecto.getEstado());
        assertEquals(fechaIngresada, proyecto.getFechaCreacion());
        assertEquals(descripcionIngresada, proyecto.getDescripcion());
    }

    @Given("^Que se quiere eliminar un proyecto con los datos (.*), lider (.*), fecha (.*) y descripcion: (.*)$")
    public void setDatosProyectoAEliminar(String nombre, String lider, String fechaCreacion, String descripcion){
        proyecto = crearProyecto(nombre, lider, fechaCreacion,descripcion);
    }

    @When("^Elimino un proyecto$")
    public void eliminoProyecto(){
        eliminarProyecto(proyecto.getCodigo());
    }

    @Then("^Se eliminará el proyecto del sistema$")
    public void verificacionProyectoNoEsta(){
        assertEquals(Optional.empty(), buscarProyectoPorCodigo(proyecto.getCodigo()));
    }

    @Given("^Que se quiere modificar un proyecto con nombre (.*), lider (.*), fecha (.*) y descripcion: (.*)")
    public void setDatosProyectoAEditar(String nombre, String lider, String fechaCreacion, String descripcion){
        proyecto = crearProyecto(nombre, lider, fechaCreacion,descripcion);
    }

    @When("^Modifico el nombre a (.*) y la fecha a (.*)$")
    public void modificoDatosProyecto(String nombre, String fecha){
        proyecto = modificarProyecto(proyecto.getCodigo() ,nombre, this.liderProyecto, fecha, this.descripcion, proyecto.getEstado());
    }

    @Then("^Se me actualizará la información del mismo a nombre (.*) y fecha (.*)$")
    public void verificarDatosProyectoActualizados(String nombre, String fecha){
        assertEquals(nombre, proyecto.getNombre());
        assertEquals(fecha, proyecto.getFechaCreacion());

    }

}
