package Frontend

import backend.modelo.Producto

open class Handler(val code: Int, val type: String, open val message: String)
class ClienteView(val idCliente:Long?,val nombre: String, val apellido: String, val domicilio: String, val contacto: Int, val cuit: String, val esConsumidorFinal: Boolean, val esResponsableInscripto: Boolean)
data class ProductoView(val idCodigo: Int, val descripcion: String, val precioCompra: Double, val precioVenta: Double) {
    constructor(producto: Producto) : this(producto.idCodigo, producto.descripcion, producto.precioCompra, producto.precioVenta)
}