package backend.modelo


class Ferreteria(var nombre: String) {

    val clientes = ArrayList<Cliente>();
    val productos = ArrayList<Producto>()
    var ventas = ArrayList<Venta>();


    fun agregarCliente(cliente: Cliente) {

        this.clientes.add(cliente)
    }

    fun agregarProducto(producto: Producto) {
        this.productos.add(producto)
    }

    fun realizarVenta(producto: Producto, unidades: Int, idCliente : String) {
        val productosEnStock = this.productos
        this.ventas.add(Venta(producto.idCodigo, idCliente, producto.precioVenta, unidades));
        removerDeStock(producto.idCodigo, unidades, productosEnStock)
    }

    fun removerDeStock(idProducto: Int, unidades: Int, productos: ArrayList<Producto>) {
        for (producto in productos) {
            if (producto.idCodigo == idProducto) {
                producto.stock = (producto.stock - unidades)
            }
        }
    }

    fun stockActualDe(idProducto: Int) : Int {
        val productosEnStock = this.productos
        for (producto in productosEnStock) {
            if (producto.idCodigo === idProducto) {
               return producto.stock
            }
        }
        return 0
    }

}



