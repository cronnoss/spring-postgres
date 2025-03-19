# spring-postgres

- Deploy locally postgresql DB, create table users (id bigserial primary key, username varchar(255) unique);

- Create Maven project and connect to it: postgresql driver, hickaricp, spring context.

- Create connection pool as Spring bean

- Create User class (Long id, String username)

- Implement UserDao class as bean which allows to perform CRUD operations on users

- Implement UserService as bean which allows to: create, delete, get one, get all users from database

- Create Spring Context, get UserService bean from it and perform all possible operations

# hw05

Correct your service:

- instead of the existing user entity, make it Entity

- Connect the Spring data jpa starter

- put all the settings in the application.yml/properties file

- describe the repository for working with the entity, you can use Query if you consider it necessary

- correct the UserService methods to work with the repository

- describe the CommandLineRunner class and perform possible operations

- add a migration to the project to create database tables, initialize the test data set in the database

# hw06

- Improve the service, let it now store customer products.

- Storage of products must be organized similarly to previously added users.

- Each user can have several products, but each product has one user.

- Customer product: id, account number, balance, product type (account, card), userId.

- The service must store products.

- The service must provide the ability to: request all products by userId, request a product by productId.

- All changes to the database are performed through the migration tool added earlier.

# hw07

- Add the payment core service to one project with the product service as a separate module

- Add integration of the payment service with the product service via RestTemplate (or RestClient)

- Add the ability to request products from the payment service (the client sends a request to the payment service, the payment service requests the client's products from the product service and returns the result to the client)

- Add the payment execution process, as well as the selection of a product, checking its existence and the sufficiency of funds on it

- Add returning errors to the client about problems both on the payment service side and on the product service side

# how to run

- install liquibase https://docs.liquibase.com/start/install/home.html
- make run-postgres
- make create-db-users
- make create-schema-users
- cd products-app
- mvn spring-boot:run
- cd ../payments-core
- mvn spring-boot:run