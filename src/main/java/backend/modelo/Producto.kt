package backend.modelo

import javax.persistence.*


@Entity
@Table(name = "producto")

class Producto {
    @Id
    var idCodigo: Int
    @Column(name = "descripcion")
    var descripcion: String
    @Column(name = "precioCompra")
    var precioCompra: Double
    @Column(name = "precioVenta")
    var precioVenta: Double
    @Column(name = "stock")
    var stock: Int

    constructor(idCodigo: Int, descripcion: String, precioCompra: Double, precioVenta: Double, stock: Int) {
        this.idCodigo = idCodigo
        this.descripcion = descripcion
        this.precioCompra = precioCompra
        this.precioVenta = precioVenta
        this.stock = stock
    }


}
