package backend.modelo

import javax.persistence.*

@Entity
@Table(name = "ventas")
class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    @Column(name = "idCodigo")
    var idCodigo: Int
    @Column(name = "clienteId")
    var clienteId: String
    @Column(name = "precioVenta")
    var precioVenta: Double
    @Column(name = "cantidad")
    var unidades: Int


    constructor(idCodigo: Int, clienteId: String, precioVenta: Double, unidades: Int) {
        this.idCodigo = idCodigo
        this.clienteId = clienteId
        this.precioVenta = precioVenta
        this.unidades = unidades

    }

}