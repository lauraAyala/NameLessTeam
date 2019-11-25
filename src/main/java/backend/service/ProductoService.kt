package backend.service


import backend.dao.ProductoDAO
import backend.modelo.Producto

class ProductoService {


    private var productoDAO = ProductoDAO()

    val allProductos: Collection<Producto?>?
        get() = run { this.productoDAO!!.getAllProducts() }

    fun guardarProducto(producto: Producto) {
        run { this.productoDAO!!.guardar(producto) }
    }

}