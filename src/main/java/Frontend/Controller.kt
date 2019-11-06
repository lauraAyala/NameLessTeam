package Frontend

import Backend.Cliente
import Backend.Ferreteria
import Backend.Producto
import io.javalin.http.Context
import Frontend.Handler

class ControllerStock(){

    val ferreteria = Ferreteria("Bacco")

    fun crearCliente(ctx : Context){
        val validar = Validar()
        val cliente = validar.validarCliente(ctx)
        try{
            val clienteNuevo = Cliente(cliente.nombre,cliente.apellido,cliente.domicilio,cliente.contacto,cliente.cuit,cliente.esConsumidorFinal,cliente.esResponsableInscripto);

            ferreteria.agregarCliente(clienteNuevo);

            ctx.status(201)
            ctx.json(clienteNuevo)
        }
        catch(e: IllegalArgumentException){
            ctx.json(Handler(400,"Bad_Request","El cliente ya existe"))
        }
    }

    fun crearProducto(ctx : Context){
        val validar = Validar()
        val nuevoProducto = validar.validarProducto(ctx)

        try{
            val producto = Producto(nuevoProducto.idCodigo, nuevoProducto.descripcion, nuevoProducto.aplicaDescuento, nuevoProducto.aplicaPromo, nuevoProducto.precioCompra, nuevoProducto.precioVenta)
            ferreteria.agregarProducto(producto)
            ctx.status(201)
            ctx.json(producto)
        }catch(e: IllegalArgumentException){
            ctx.json(Handler(400,"Bad_Request","El producto ya existe"))
        }
    }

}