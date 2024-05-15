**API RESTOSERV**

Para que el programa RestoServ sea funcional, va acompañado de una base de datos y su respectiva API Rest creada con Spring Boot.
Aquí queda anotada toda la información relevante para su uso.

**GET :**

**Categorías :**

OBTENER TODAS LAS CATEGORIAS:

http://localhost:8080/RestoServ/api/categorias

OBTENER CATEGORIA ESPECIFICA

http://localhost:8080/RestoServ/api/categorias/{nomCat}

Ejemplo: http://localhost:8080/RestoServ/api/categorias/bebida

Opciones: pizza, bebida, postre, entrante.

**Clientes :** 

OBTENER TODOS LOS CLIENTES:

http://localhost:8080/RestoServ/api/clientes

OBTENER CLIENTE CONCRETO:

http://localhost:8080/RestoServ/api/clientes/{telf}

Ejemplo: http://localhost:8080/RestoServ/api/clientes/666999666

**Órdenes:** 

OBTENER TODAS LAS ÓRDENES:

http://localhost:8080/RestoServ/api/ordenes (De momento no saca info porque no me deja crear órdenes:( ).

OBTENER PEDIDOS POR ID:

http://localhost:8080/RestoServ/api/ordenes/{ordenId}

Ejemplo: http://localhost:8080/RestoServ/api/ordenes/1

**Detalle pedidos :**

**Empleados:** 

OBTENER TODOS LOS EMPLEADOS : 

http://localhost:8080/RestoServ/api/empleados

OBTENER EMPLEADO POR ID:

http://localhost:8080/RestoServ/api/empleados/{emplId}

Ejemplo: http://localhost:8080/RestoServ/api/empleados/1

**Productos :** 

OBTENER TODOS LOS PRODUCTOS:

http://localhost:8080/RestoServ/api/productos

OBTENER PRODUCTOS POR NOMBRE: 

http://localhost:8080/RestoServ/api/productos/{nomProd}

Ejemplo: http://localhost:8080/RestoServ/api/productos/fanta naranja

**POST :**

**Crear cliente:** 
 
 http://localhost:8080/RestoServ/api/clientes
 
Ejemplo:

Datos mínimos para crear cliente:

{
"telf": 1111222333,

"nom_cli": "PABLO"
}


**Crear pedido:  (no va)**

http://localhost:8080/RestoServ/api/clientes
 
Aún no puedo aportar JSON válido para esta llamada.
 

**Crear detalle orden:  (no va)**

http://localhost:8080/RestoServ/api/detalleOrdenes

Aún no puedo aportar JSON válido para esta llamada.

**PUT :**

**Actualizar cliente:** 
 
http://localhost:8080/RestoServ/api/clientes
 
Ejemplo: 
 
{
"telf": 1111222333,

"nom_cli": "PABLO",

"direccion": "calle falsa, 123"
}

Si no se pone el nombre dará error.




