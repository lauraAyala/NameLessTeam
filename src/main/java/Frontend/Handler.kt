package Frontend

import Backend.Producto

open class Handler(val code: Int, val type: String, open val message: String)
class ClienteView(val nombre : String,val apellido: String,val domicilio: String, val contacto: Int, val cuit: String, val esConsumidorFinal: Boolean, val esResponsableInscripto: Boolean)
data class ProductoView(val idCodigo : Int,val descripcion: String, val aplicaDescuento : Boolean, val aplicaPromo : Boolean, val precioCompra : Double, val precioVenta : Double){
    constructor(producto: Producto) : this(producto.idCodigo, producto.descripcion,producto.aplicaDescuento, producto.aplicaPromo,producto.precioCompra,producto.precioVenta)
}