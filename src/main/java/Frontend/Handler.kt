package Frontend

import backend.modelo.Cliente
import backend.modelo.Producto
import backend.modelo.Venta

open class Handler(val code: Int, val type: String, open val message: String)

data class ClienteView(val nombre: String, val apellido: String, val domicilio: String, val contacto: Int, val cuit: String, val esConsumidorFinal: Boolean, val esResponsableInscripto: Boolean) {
    constructor(cliente: Cliente) : this(cliente.nombre, cliente.apellido, cliente.domicilio, cliente.contacto, cliente.cuit, cliente.esConsumidorFinal, cliente.esConsumidorFinal)
}

data class ProductoView(val idCodigo: Int, val descripcion: String, val precioCompra: Double, val precioVenta: Double, val stock : Int) {
    constructor(producto: Producto) : this(producto.idCodigo, producto.descripcion, producto.precioCompra, producto.precioVenta, producto.stock)
}

data class VentaView(val idCodigo: Int,  val clienteId: String, val precioVenta: Double, val unidades : Int) {
    constructor(venta: Venta) : this(venta.idCodigo,  venta.clienteId, venta.precioVenta, venta.unidades)

}