db-iniciar:
	cd ./tools && docker-compose up -d

db-iniciar-logs:
	cd ./tools && docker-compose up

db-frenar:
	cd ./tools && docker-compose stop

db-borrar:
	cd ./tools && docker-compose down -v

