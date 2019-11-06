package Backend
import kotlin.random.Random

class Ferreteria(var nombre : String) {

    val clientes = ArrayList<Cliente>();
    val productos = ArrayList<Producto>()

    fun agregarCliente(cliente : Cliente){

        this.clientes.add(cliente)
    }

    fun agregarProducto(producto : Producto){
        this.productos.add(producto)
    }


}



