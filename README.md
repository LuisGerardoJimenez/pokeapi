
# PokeAPI

PokeAPI es una API que, mediante Feign, realiza la consulta de información de https://pokeapi.co/ en donde podemos obtenes los Pokemon y el detalle de cada uno de ellos como lo es:

- abilities
- base_experience
- held_items
- id
- name
- location_area_encounters


## DB Instalación

La base de datos utilizada es **PostgreSQL 16**, por lo que se deberá realizar la instalación de pgAdmin desde su página oficial:

https://www.pgadmin.org/

Una vez intalado, ejecutaremos los queries que se encuentran en el archivo **pokeApiDB.sql** en la raiz del proyecto

**NOTA:** El puerto asignado es el default **5432**

Para terminar, es importante que se cambien los datos username y password, con los ingresados durante la instalación de pgAdmin, en el archivo **application-dev.yml** ubicado dentro de la carpeta **src/main/resources**

- spring > datasource > username
- spring > datasource > password


## Instalación

### Clona el proyecto

```bash
  git clone https://github.com/LuisGerardoJimenez/pokeapi
```

### Ve al directorio del proyecto

```bash
  cd pokeapi
```

### Instala las dependencias

```bash
  mvn clean install -Pdev -DskipTests
```

La bandera **-Pdev** sirve para utilizar el profile de DEV 

La bandera **-DskipTests** sirve para evitar las pruebas y que únicamente realice la compilación

### Iniciamos el servidor

Una vez que tenemos el **.jar** lo vamos a ejecutar con el siguiente comando:

```bash
  mvn spring-boot:run
```

Cuando en la consola aparezca **Started PokeapiApplication in** el proyecto estará ejecutandose en el puerto **8080** con el contexto base **/**


## Documentación

El proyecto cuenta con Swagger integrado, por lo que se podrán ver los webservices disponibles:

http://localhost:8080/swagger-ui/index.html

## Pruebas

Para realizar pruebas utilizaremos **Postman**

La prueba necesita una autorización basica con el usuario definido en la propiedad:

- spring > security > user > name
- spring > security > user > password

![Postman Authorization](/src/main/resources/img/postman.jpg)

Realizamos la peticion tipo **GET** y observamos la respuesta

![Resultado Postman](/src/main/resources/img/resultado.jpg)

De la misma manera se pueden realizar pruebas directamente en la interfaz de usuario de **Swagger**

## Authors

- [@LuisGerardoJimenez](https://github.com/LuisGerardoJimenez)

