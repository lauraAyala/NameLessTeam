package Frontend

import Backend.Cliente
import io.javalin.http.Context
import io.javalin.http.Handler

class Validar {

    fun validarCliente(cxt: Context):ClienteView {
        val cliente = cxt.bodyValidator(ClienteView::class.java)
        try {

            cliente.check({ it.nombre!!.isNotBlank() }, "Name can't be empty ").get()
            cliente.check({ it.nombre!!.matches(Regex("^[a-zA-Z*]*$")) }, "The first name can only be composed of latters").get()
            cliente.check({ it.apellido!!.isNotBlank() }, "Lastname can't be empty ").get()
            cliente.check({ it.apellido!!.matches(Regex("^[a-zA-Z*]*$")) }, "The last name can only be composed of latters  ").get()
            cliente.check({ it.domicilio!!.isNotBlank() }, "domicilio no puede ser vacio").get()
            cliente.check({ it.cuit!!.isNotBlank() }, "cuit no puede ser vacio").get()
            cliente.check({ it.cuit!!.matches(Regex("^[0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}$")) }, "el cuit tiene que tener numeros positivos").get()
            cliente.check({ it.esConsumidorfinal!! == true ||  it.esConsumidorfinal == false }, "tiene que se un booleano").get()
            cliente.check({ (it.esResponsableInscripto!== true) ||  (it.esConsumidorfinal == false) }, "tiene que se un booleano").get()
        }catch (e:NoSuchElementException){
            cxt.status(400)
            //cxt.json(Handler(400, "Bad request", e.message!!))
        }catch (e:java.lang.Exception){
            cxt.status(400)
            //cxt.json(Handler(400, "Bad request", "Json keys must be firstName, lastName,password,idCard y email"))
        }
        return cliente.get()
    }

    fun validarProducto(ctx: Context):ProductoView{
        val producto = ctx.bodyValidator(ProductoView::class.java)
        try{
            producto.check({ it.idCodigo!!.toString().isNotBlank() }, "idCodigo no puede estar vacio ").get()
            producto.check({ it.idCodigo!!.toString().matches(Regex("\\d*")) }, "idCodigo no pueden ser letras, sino numeros").get()
            producto.check({ it.descripcion!!.isNotBlank() }, "descripcion no puede estar vacia").get()
            producto.check({ it.descripcion!!.matches(Regex("^[a-zA-Z*]*$")) }, "Descripcion debe tener un formato de letras").get()
            producto.check({ it.precioCompra!!.toString().isNotBlank() }, "precio de compra no puede ser vacio").get()
            producto.check({ it.precioVenta!!.toString().isNotBlank() }, "precio de venta no puede ser vacio").get()

        }catch (e: NoSuchElementException){
            ctx.json(Handler(400, "Bad request", e.message!!))
        }catch (e:java.lang.Exception){
            ctx.json(Handler(400, "Bad request", "Error en la estructura de la consulta JSON"))
        }
    return producto.get()
    }
}



