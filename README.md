# Proyectos-app

## Swagger

- Local: http://localhost:8090/swagger-ui.html
- Heorku: https://modulo-proyectos-squad7.herokuapp.com/swagger-ui.html

## Base de datos

La base de datos está implementada con [PostgreSQL](https://es.wikipedia.org/wiki/PostgreSQL). La base de datos está dockerizada, por lo que solo con tener instalado [Docker](https://docs.docker.com/engine/install/ubuntu/) y [Docker Compose](https://docs.docker.com/compose/install/) es suficiente.
Todos los archivos de configuración ligados a Docker están en [tools](tools).

Los datos de conexión a la base de datos localmente son:
```bash
host: 127.0.0.1
puerto: 5434
usuario: username
constraseña: password
database: proyectos_db
```

Para interactuar facilmente con la base de datos tenemos tenemos los siguientes comandos:

**Iniciar la Base de Datos**

Si no está levantada, la app no se podrá conectar a la DB.

Iniciar la base:

```bash
$ make db-iniciar
```

Para iniciar la base de datos mostrando logs en pantalla:
```bash
$ make db-iniciar-logs
```

**Apagar la Base de Datos**

```bash
$ make db-frenar
```

**Borrar la Base de Datos**

Si se corre este comando será irreversible la perdida de toda la información que hubiera en la base

```bash
$ make db-borrar
```

**NOTA:** No es mandatorio usar Docker para gestionar la base de datos, se puede usar PostgreSQL directamente instalado en el sistema (je, cuidado con problemas del tipo *En mi máquina funciona bien*)
