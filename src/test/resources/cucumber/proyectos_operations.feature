Feature: Proyectos operations
  Checking proyectos operations

  Scenario: Crear proyecto correctamente
    Given Que se quiere crear un proyecto con nombre Proyecto A, lider Carlos Marquez, fecha 20/12/2020 y descripcion: desarrollo del API de la aplicacion de PSA
    When Creo un proyecto
    Then Se carga en el sistema con los datos correspondientes, Proyecto A, Carlos Marquez, 20/12/2020, desarrollo del API de la aplicacion de PSA

  Scenario: Eliminar un proyecto
    Given Que se quiere eliminar un proyecto con los datos Proyecto B, lider Marcela Suarez, fecha 12/07/2018 y descripcion: desarrollo y testeo de nueva aplicacion
    When Elimino un proyecto
    Then Se eliminará el proyecto del sistema

  Scenario: Modificar datos de un proyecto
    Given Que se quiere modificar un proyecto con nombre Proyecto C, lider Ana Martinez, fecha 20/01/2020 y descripcion: desarrollo de la aplicacion bancaria
    When Modifico el nombre a Proyecto C2 y la fecha a 19/01/2020
    Then Se me actualizará la información del mismo a nombre Proyecto C2 y fecha 19/01/2020