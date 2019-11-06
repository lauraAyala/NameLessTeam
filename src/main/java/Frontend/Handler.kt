package Frontend

open class Handler(val code: Int, val type: String, open val message: String)
class ClienteView(val nombre : String,val apellido: String,val domicilio: String, val contacto: Int, val cuit: String, val esConsumidorfinal: Boolean, val esResponsableInscripto: Boolean)
class ProductoView(val idCodigo : Int,val descripcion: String, val aplicaDescuento : Boolean, val aplicaPromo : Boolean, val precioCompra : Double, val precioVenta : Double)