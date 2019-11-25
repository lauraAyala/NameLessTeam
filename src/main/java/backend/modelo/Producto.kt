package backend.modelo

import javax.persistence.*


@Entity
@Table

class Producto() {

    @Id
    @GeneratedValue
    var id: Int? = null

    var idCodigo: Int = 0

    lateinit var descripcion: String

    var precioCompra: Double = 0.0

    var precioVenta: Double = 0.0

    var stock: Int = 0

    constructor(idCodigo: Int, descripcion: String, precioCompra: Double, precioVenta: Double, stock:Int) : this() {
        this.idCodigo = idCodigo
        this.descripcion = descripcion
        this.precioCompra = precioCompra
        this.precioVenta = precioVenta
        this.stock = stock
    }


}
