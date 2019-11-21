package backend.service


import backend.dao.DataDAO
import backend.dao.ProductoDAO
import backend.modelo.Producto

class ProductoService {


    private val productoDAO = ProductoDAO()
    private val dataDAO: DataDAO? = null

    val allProductos: Collection<Producto?>?
        get() = run { this.productoDAO!!.getAllProducts() }

    fun guardarProducto(producto: Producto) {
        run { this.productoDAO!!.guardar(producto) }
    }

}