# TestSpring
* Spring boot
* Maven
* PostgresSQL 9
* Jdk 1.8

## Comenzando

Se debe crear la Base de datos en postgres
```
CREATE DATABASE tarea
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Spanish_Spain.1252'
       LC_CTYPE = 'Spanish_Spain.1252'
       CONNECTION LIMIT = -1;
```

### Los endpoint definidos son: 
  *  /clientDetails
  *  /clientes
  
### Se definieron 2 test: 

* ClienteApplicationTests
* ProductoApplicationTests

### El fichero de logs: 
* app.log

