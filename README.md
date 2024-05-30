API RESTOSERV

Para que el programa RestoServ sea funcional, va acompañado de una base de datos y su respectiva API Rest creada con Spring Boot. Aquí queda anotada toda la información relevante para su uso.
Endpoints
GET
Categorías

    Obtener todas las categorías:

    bash

GET /RestoServ/api/categorias

http://localhost:8080/RestoServ/api/categorias

Obtener categoría específica:

swift

    GET /RestoServ/api/categorias/{nomCat}

    Ejemplo: http://localhost:8080/RestoServ/api/categorias/bebida

    Opciones: pizza, bebida, postre, entrante.

Clientes

    Obtener todos los clientes:

    bash

GET /RestoServ/api/clientes

http://localhost:8080/RestoServ/api/clientes

Obtener cliente concreto:

swift

    GET /RestoServ/api/clientes/{telf}

    Ejemplo: http://localhost:8080/RestoServ/api/clientes/666999666

Órdenes

    Obtener todas las órdenes:

    bash

GET /RestoServ/api/ordenes

http://localhost:8080/RestoServ/api/ordenes
(De momento no saca info porque no me deja crear órdenes :( ).

Obtener pedidos por ID:

swift

GET /RestoServ/api/ordenes/{ordenId}

Ejemplo: http://localhost:8080/RestoServ/api/ordenes/1

Obtener órdenes no hechas (cocina):

swift

    GET /RestoServ/api/ordenes/undone

    http://localhost:8080/RestoServ/api/ordenes/undone

Detalle pedidos

    Obtener todos los detalles de todos los pedidos:

    bash

    GET /RestoServ/api/detalleOrdenes

    http://localhost:8080/RestoServ/api/detalleOrdenes

    En una segunda versión de la API sacaré un EndPoint que saque los detalles de orden de cada orden, será menos lioso y más útil.

Empleados

    Obtener todos los empleados:

    bash

GET /RestoServ/api/empleados

http://localhost:8080/RestoServ/api/empleados

Obtener empleado por ID:

swift

GET /RestoServ/api/empleados/{emplId}

Ejemplo: http://localhost:8080/RestoServ/api/empleados/1

Obtener empleado por código:

swift

GET /RestoServ/api/empleados/{codigo}

Ejemplo: http://localhost:8080/RestoServ/api/empleados/1011

Obtener empleado por código y nombre (AUTH):

swift

    GET /RestoServ/api/empleados/{codigo}?{nomEmpl}

    Ejemplo: http://localhost:8080/RestoServ/api/empleados/1012?mario

Productos

    Obtener todos los productos:

    bash

GET /RestoServ/api/productos

http://localhost:8080/RestoServ/api/productos

Obtener productos por nombre:

swift

    GET /RestoServ/api/productos/{nomProd}

    Ejemplo: http://localhost:8080/RestoServ/api/productos/fanta naranja

POST
Crear cliente:

bash

POST /RestoServ/api/clientes

http://localhost:8080/RestoServ/api/clientes

Ejemplo:

json

{
    "telf": 1111222333,
    "nom_cli": "PABLO"
}

Crear pedido:

swift

POST /RestoServ/api/ordenes/createOrder

http://localhost:8080/RestoServ/api/ordenes/createOrder

Ejemplo:

json

{
    "cliente": {
        "telf": 12345
    },
    "empleado": {
        "emplId": 1
    },
    "detallesOrden": [
        {
        }
    ]
}

Este ejemplo crea una orden vacía, después con detalles orden es cuando rellenamos con información.
Crear detalle orden:

bash

POST /RestoServ/api/detalleOrdenes

http://localhost:8080/RestoServ/api/detalleOrdenes

Ejemplo:

json

{
    "orden": {
        "ordenId": 21
    },
    "producto": {
        "prodId": 12
    },
    "cantidad": 2
}

PUT
Actualizar cliente:

bash

PUT /RestoServ/api/clientes

http://localhost:8080/RestoServ/api/clientes

Ejemplo:

json

{
    "telf": 1111222333,
    "nom_cli": "PABLO",
    "direccion": "calle falsa, 123"
}

Si no se pone el nombre dará error.
Editar órdenes:

swift

PUT /RestoServ/api/ordenes/updateOrder/{ordenId}

http://localhost:8080/RestoServ/api/ordenes/updateOrder/{ordenId}

Ejemplo:

json

{
    "hecho": true
}

DELETE
Eliminar cliente:

swift

DELETE /RestoServ/api/clientes/{telf}

http://localhost:8080/RestoServ/api/clientes/{telf}

Devuelve NoContentBuild.
Eliminar pedido por ID:

swift

DELETE /RestoServ/api/ordenes/deleteOrder/{ordenId}

http://localhost:8080/RestoServ/api/ordenes/deleteOrder/{ordenId}

Devuelve NoContentBuild.
