package backend.modelo

import javax.persistence.*

@Entity
@Table
class Venta() {

    @Id
    @GeneratedValue
    var id: Int? = null

    var idCodigo: Int = 0

    lateinit var clienteId: String

    var precioVenta: Double = 0.0

    var unidades: Int = 0


    constructor(idCodigo: Int, clienteId: String, precioVenta: Double, unidades: Int) : this() {
        this.idCodigo = idCodigo
        this.clienteId = clienteId
        this.precioVenta = precioVenta
        this.unidades = unidades

    }

}