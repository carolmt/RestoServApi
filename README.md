# API RESTOSERV


Para que el programa RestoServ sea funcional, va acompañado de una base de datos y su respectiva API Rest creada con Spring Boot.
Aquí queda anotada toda la información relevante para su uso.


## API KEY


RestoServApi tiene un método de seguridad, el cual solo autoriza cualquier llamada con la key correspondiente y estática. De momento tiene una seguridad "basica".
Para poder hacer uso de esta api, se deberá poner en el header la Key y Value.
Esta información se encuentra en el código, o preguntando a la administradora (yo).



### GET


**-Categorías :**


- OBTENER TODAS LAS CATEGORIAS:
	
http://localhost:8080/RestoServ/api/categorias
	

- OBTENER CATEGORIA ESPECIFICA

http://localhost:8080/RestoServ/api/categorias/{nomCat}

Ejemplo: http://localhost:8080/RestoServ/api/categorias/bebida
	
Opciones: pizza, bebida, postre, entrante.



**Clientes :** 



- OBTENER TODOS LOS CLIENTES:

http://localhost:8080/RestoServ/api/clientes


- OBTENER CLIENTE CONCRETO:

http://localhost:8080/RestoServ/api/clientes/{telf}

Ejemplo: http://localhost:8080/RestoServ/api/clientes/666999666



**Órdenes:** 



- OBTENER TODAS LAS ÓRDENES:

http://localhost:8080/RestoServ/api/ordenes (De momento no saca info porque no me deja crear órdenes:( ).


- OBTENER PEDIDOS POR ID:

http://localhost:8080/RestoServ/api/ordenes/{ordenId}

Ejemplo: http://localhost:8080/RestoServ/api/ordenes/1


- OBTENER ORDENES NO HECHAS (cocina):

http://localhost:8080/RestoServ/api/ordenes/undone



**Detalle pedidos :**



- OBTENER TODOS LOS DETALLES DE TODOS LOS PEDIDOS:

http://localhost:8080/RestoServ/api/detalleOrdenes

En una segunda versión de la API sacaré un EndPoint que saque los detalles de orden de cada orden, será menos lioso y más útil.



**Empleados:** 



- OBTENER TODOS LOS EMPLEADOS : 

http://localhost:8080/RestoServ/api/empleados


- OBTENER EMPLEADO POR ID:

http://localhost:8080/RestoServ/api/empleados/{emplId}

Ejemplo: http://localhost:8080/RestoServ/api/empleados/1


- OBTENER EMPLEADO POR CODIGO

http://localhost:8080/RestoServ/api/empleados/{codigo}

Ejemplo: http://localhost:8080/RestoServ/api/empleados/1011


- OBTENER EMPLEADO POR CODIGO Y NOMBRE (AUTH)

http://localhost:8080/RestoServ/api/empleados/{codigo}?{nomEmpl}

Ejemplo: http://localhost:8080/RestoServ/api/empleados/1012?mario



**Productos :** 



- OBTENER TODOS LOS PRODUCTOS:

http://localhost:8080/RestoServ/api/productos


- OBTENER PRODUCTOS POR NOMBRE: 

http://localhost:8080/RestoServ/api/productos/{nomProd}

Ejemplo: http://localhost:8080/RestoServ/api/productos/fanta naranja



### POST



**- Crear cliente:** 
 
http://localhost:8080/RestoServ/api/clientes
 
Ejemplo:

Datos mínimos para crear cliente:

	{
	"telf": 1111222333,
	
	"nom_cli": "PABLO"
	}



**- Crear pedido:**

http://localhost:8080/RestoServ/api/ordenes/createOrder
 
Ejemplo:

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



**- Crear detalle orden:**

http://localhost:8080/RestoServ/api/detalleOrdenes

Ejemplo: 
	
	{
	    "orden": {
	        "ordenId": 21
	    },
	    "producto": {
	        "prodId": 12
	    },
	    "cantidad": 2
	}



### PUT



**- Actualizar cliente:** 
 
http://localhost:8080/RestoServ/api/clientes
 
Ejemplo: 
 
	{
	"telf": 1111222333,
	
	"nom_cli": "PABLO",
	
	"direccion": "calle falsa, 123"
	}

Si no se pone el nombre dará error.



**- Editar Ordenes:**

http://localhost:8080/RestoServ/api/ordenes/updateOrder/{ordenId}

Ejemplo:

	{
	    "hecho" : true
	}



### DELETE



**- Eliminar cliente:**

http://localhost:8080/RestoServ/api/clientes/{telf}

Devuelve NoContentBuild



**- Eliminar pedido por id:**

http://localhost:8080/RestoServ/api/ordenes/deleteOrder/{ordenId}

Devuelve NoContentBuild
