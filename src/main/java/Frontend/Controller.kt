package Frontend

import backend.modelo.Cliente
import backend.modelo.Ferreteria
import backend.modelo.Producto
import io.javalin.http.Context

class ControllerStock(){

    val ferreteria = Ferreteria("Bacco")

    fun crearCliente(ctx : Context){
        val validar = Validar()
        val cliente = validar.validarCliente(ctx)
        try{
            val clienteNuevo = Cliente(cliente.idCliente,cliente.nombre, cliente.apellido, cliente.domicilio, cliente.contacto, cliente.cuit, cliente.esConsumidorFinal, cliente.esResponsableInscripto);

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
            val producto = Producto(nuevoProducto.idCodigo, nuevoProducto.descripcion, nuevoProducto.precioCompra, nuevoProducto.precioVenta)
            ferreteria.agregarProducto(producto)
            ctx.status(201)
            ctx.json(producto)
        }catch(e: IllegalArgumentException){
            ctx.json(Handler(400,"Bad_Request","El producto ya existe"))
        }
    }

    fun getProductos(ctx: Context) {
        ctx.status(200)
        ctx.json(ferreteria.productos.map { ProductoView(it) })
    }

}