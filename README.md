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
Se accede a la Url /login pasandole por parámetros nombre y contraseña , la cual va a verificar contra el fichero de usuarios , Obtenemos el token , que ponemos en el Authorization y se podrá acceder a los demas endpoint definidos.

### Los endpoint definidos son: 
  *  /clientDetails
  *  /clientes
  *  /clienteCreate
  *  /productos
  *  /productCreate
  *  /productDelete
  *  /login
  *  /addventa
  
### Se definieron 2 test: 

* ClienteApplicationTests
* ProductoApplicationTests

### El fichero de logs: 
* app.log

### El fichero de usuarios usuarios.txt

