Feature: Proyectos operations
  Checking proyectos operations

  Scenario: Crear proyecto nuevo
    Given Que se quiere crear un proyecto
    When Creo un proyecto
    Then Se carga el proyecto en el sistema con los datos correspondientes

  Scenario: Eliminar un proyecto
    Given Que se quiere eliminar un proyecto
    When Elimino un proyecto
    Then Se eliminara el proyecto del sistema

  Scenario: Eliminar un proyecto finalizado
    Given Que se quiere eliminar un proyecto finalizado
    When Elimino un proyecto
    Then No se eliminara el proyecto del sistema

  Scenario: Editar datos de un proyecto
    Given Que se quiere editar un proyecto
    When Edito el proyecto
    Then Se me actualizara la informacion del mismo

  Scenario: Editar datos de un proyecto finalizado
    Given Que se quiere editar un proyecto finalizado
    When Edito el proyecto
    Then No se me actualizara la informacion del mismo

  Scenario: Consultar todos los proyectos con el mismo nombre
    Given Que se quiere filtrar los proyectos por nombre
    When Hago el filtrado por nombre
    Then Se me mostraran solo los proyectos pedidos

  Scenario: Consultar todos los proyectos con estado en curso
    Given Que se quiere filtrar los proyectos por estado
    When Hago el filtrado por estado en curso
    Then Se me mostraran solo los proyectos con estado en curso

  Scenario: Consultar todos los proyectos con estado finalizado
    Given Que se quiere filtrar los proyectos por estado
    When Hago el filtrado por estado finalizado
    Then Se me mostraran solo los proyectos con estado finalizado

  Scenario: Consultar todos los proyectos con el mismo lider
    Given Que se quiere filtrar los proyectos por lider
    When Hago el filtrado por lider
    Then Se me mostraran solo los proyectos con el lider elegido

  Scenario: fecha
     Given que se quiere fecha

