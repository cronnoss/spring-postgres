# spring-postgres

- Deploy locally postgresql DB, create table users (id bigserial primary key, username varchar(255) unique);

- Create Maven project and connect to it: postgresql driver, hickaricp, spring context.

- Create connection pool as Spring bean

- Create User class (Long id, String username)

- Implement UserDao class as bean which allows to perform CRUD operations on users

- Implement UserService as bean which allows to: create, delete, get one, get all users from database

- Create Spring Context, get UserService bean from it and perform all possible operations