run-postgres:
	docker run -d --rm --name pg -e POSTGRES_USER=root -e POSTGRES_PASSWORD=secretkey -e PGDATA=/var/lib/postgresql/data/pgdata -v psqldata:/var/lib/postgresql/data -p 5432:5432 postgres:latest

create-db:
	docker exec -it pg createdb --username=root --owner=root users

drop-db:
	docker exec -it pg dropdb users

db-connect:
	docker exec -it pg psql -U root -d users \
		-c "CREATE TABLE users (id BIGSERIAL PRIMARY KEY, username VARCHAR(255) unique);"

.PHONY: run-postgres create-db drop-db db-connect
