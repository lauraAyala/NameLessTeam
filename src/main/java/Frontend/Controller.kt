package Frontend

import backend.modelo.Cliente
import backend.modelo.Ferreteria
import backend.modelo.Producto
import backend.modelo.Venta
import backend.service.ClienteService
import io.javalin.http.Context

class ControllerStock() {

    val ferreteria = Ferreteria("Bacco")
    val clienteService = ClienteService();

    fun crearCliente(ctx: Context) {
        val validar = Validar()
        val cliente = validar.validarCliente(ctx)
        try {
            val clienteNuevo = Cliente(cliente.nombre, cliente.apellido, cliente.domicilio, cliente.contacto, cliente.cuit, cliente.esConsumidorFinal, cliente.esResponsableInscripto);

            ferreteria.agregarCliente(clienteNuevo);
            clienteService.guardarCliente(clienteNuevo)
            ctx.status(201)
            ctx.json(clienteNuevo)
        } catch (e: IllegalArgumentException) {
            ctx.json(Handler(400, "Bad_Request", "El cliente ya existe"))
        }
    }

    fun crearProducto(ctx: Context) {
        val validar = Validar()
        val nuevoProducto = validar.validarProducto(ctx)

        try {
            val producto = Producto(nuevoProducto.idCodigo, nuevoProducto.descripcion, nuevoProducto.precioCompra, nuevoProducto.precioVenta, nuevoProducto.stock)
            ferreteria.agregarProducto(producto)
            ctx.status(201)
            ctx.json(producto)
        } catch (e: IllegalArgumentException) {
            ctx.json(Handler(400, "Bad_Request", "El producto ya existe"))
        }
    }

    fun getProductos(ctx: Context) {
        ctx.status(200)
        ctx.json(ferreteria.productos.map { ProductoView(it) })
    }

    fun getClientes(ctx: Context) {
        ctx.status(200)
        val todosLosClientes = clienteService.allClientes;
        todosLosClientes?.map { ClienteView(it!!) }?.let { ctx.json(it) }
    }

    fun realizarVenta(ctx: Context) {
        val validar = Validar()
        val venta = validar.validarVenta(ctx)
        try {
            val nuevaVenta = Venta(venta.idCodigo, venta.clienteId, venta.precioVenta, venta.unidades);
            ctx.json(nuevaVenta)
            ctx.status(201)
        } catch (e: IllegalArgumentException) {
            ctx.json(Handler(400, "Bad_Request", "No se pudo concretar la venta"))
        }

    }

}