Feature: Tareas operations
  Checking tareas operations

  Scenario: Crear tarea nueva
    Given Que se quiere crear una tarea
    When Creo una tarea
    Then Se carga la tarea en el sistema con los datos correspondientes

  Scenario: Eliminar una tarea
    Given Que se quiere eliminar una tarea
    When Elimino una tarea
    Then Se eliminara la tarea del sistema

  Scenario: Editar datos de una tarea
    Given Que se quiere editar una tarea
    When Edito la tarea
    Then Se me actualizara la informacion de la misma

  Scenario: Agregar tareas a un proyecto
    Given Que se quiere agregar tareas a un mismo proyecto
    When Agrego las tareas
    Then Las tareas deben pertenecer al proyecto

  Scenario: Consultar todas las tareas con el mismo nombre
    Given Que se quiere filtrar las tareas por nombre
    When Hago el filtrado de tareas por nombre
    Then Se me mostraran solo las tareas pedidas

  Scenario: Consultar todas las tareas con estado en curso
    Given Que se quiere filtrar las tareas por estado
    When Hago el filtrado de tareas por estado en curso
    Then Se me mostraran solo las tareas con estado en curso

  Scenario: Consultar todos las tareas con estado finalizada
    Given Que se quiere filtrar las tareas por estado
    When Hago el filtrado de tareas por estado finalizada
    Then Se me mostraran solo las tareas con estado finalizada

  Scenario: Consultar todas las tareas con el mismo empleado asignado
    Given Que se quiere filtrar las tareas por empleado asignado
    When Hago el filtrado de tareas por empleado asignado
    Then Se me mostraran solo las tareas con el empleado asignado elegido