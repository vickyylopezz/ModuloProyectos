package com.aninfo;

import com.aninfo.model.Proyecto;
import com.aninfo.model.Tarea;
import com.aninfo.service.ProyectoService;
import com.aninfo.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@SpringBootApplication
@EnableSwagger2
public class ProyectosApp {

	@Autowired
	private ProyectoService proyectoService;

	@Autowired
	private TareaService tareaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectosApp.class, args);
	}

	//Crear un proyecto
	@PostMapping("/proyectos")
	@ResponseStatus(HttpStatus.CREATED)
	public Proyecto crearProyecto(@RequestBody Proyecto proyecto) {
		proyecto.setFechaCreacion(proyecto.todayDate());
		proyecto.setEstado("CREADO");
		return proyectoService.crearProyecto(proyecto);
	}

	//Get de todos los proyectos
	@GetMapping("/proyectos")
	public Collection<Proyecto> getProyectos() {
		return proyectoService.getProyectos();
	}

	//Get de un proyecto por su codigo
	@GetMapping("/proyectos/{codigo}")
	public ResponseEntity<Proyecto> getProyecto(@PathVariable Long codigo) {
		Optional<Proyecto> proyectoOptional = proyectoService.findById(codigo);
		return ResponseEntity.of(proyectoOptional);
	}

	//Actualizar un proyecto dado un codigo
	@PutMapping("/proyectos/{codigo}")
	public ResponseEntity<Proyecto> updateProyecto(@RequestBody Proyecto proyecto, @PathVariable Long codigo) {
		Optional<Proyecto> proyectoOptional = proyectoService.findById(codigo);

		if (proyectoOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		proyecto.setId(codigo);
		proyectoService.save(proyecto);
		return ResponseEntity.noContent().build();
	}

	//Borrar un proyecto
	@DeleteMapping("/proyectos/{codigo}")
	public void deleteProyecto(@PathVariable Long codigo) {
		proyectoService.deleteById(codigo);
	}

	//Crear tarea
	@PostMapping("/proyectos/{codigoProyecto}/tareas")
	@ResponseStatus(HttpStatus.CREATED)
	public Tarea createTarea(@RequestBody Tarea tarea) {
		tarea.setEstado("CREADA");
		return tareaService.crearTarea(tarea);
	}

	//Get tareas de un proyecto especifico
	@GetMapping("/proyectos/{codigo}/tareas")
	public Collection<Tarea> getTareas(@PathVariable Long codigo) {
		return tareaService.getTareas(codigo);
	}

	//Borrar una tarea
	@DeleteMapping("/proyectos/{codigoProyecto}/tareas/{codigoTarea}")
	public void deleteTarea(@PathVariable Long codigoTarea, @PathVariable String codigoProyecto) {

		tareaService.deleteById(codigoTarea);
	}

	//Editar una tarea
	@PutMapping("/proyectos/{codigoProyecto}/tareas/{codigoTarea}")
	public ResponseEntity<Tarea> updateTarea(@RequestBody Tarea tarea, @PathVariable Long codigoTarea) {
		Optional<Tarea> tareaOptional = tareaService.findById(codigoTarea);

		if (tareaOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		tarea.setId(codigoTarea);
		tareaService.save(tarea);
		return ResponseEntity.noContent().build();
	}

	//Get de una tarea por su codigo
	@GetMapping("/proyectos/{codigoProyecto}/tareas/{codigoTarea}")
	public ResponseEntity<Tarea> getTarea(@PathVariable Long codigoTarea, @PathVariable String codigoProyecto) {
		Optional<Tarea> tareaOptional = tareaService.findById(codigoTarea);
		return ResponseEntity.of(tareaOptional);
	}

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
}
