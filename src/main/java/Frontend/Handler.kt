package Frontend

import backend.modelo.Cliente
import backend.modelo.Producto

open class Handler(val code: Int, val type: String, open val message: String)

data class ClienteView(val nombre: String, val apellido: String, val domicilio: String, val contacto: Int, val cuit: Int, val esConsumidorFinal: Boolean, val esResponsableInscripto: Boolean) {
    constructor(cliente: Cliente) : this(cliente.nombre, cliente.apellido, cliente.domicilio, cliente.contacto, cliente.cuit, cliente.esConsumidorFinal, cliente.esConsumidorFinal)
}

data class ProductoView(val idCodigo: Int, val descripcion: String, val precioCompra: Double, val precioVenta: Double) {
    constructor(producto: Producto) : this(producto.idCodigo, producto.descripcion, producto.precioCompra, producto.precioVenta)
}