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