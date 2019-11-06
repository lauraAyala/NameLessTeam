package Backend
import kotlin.random.Random

class Ferreteria(var nombre : String) {

    val clientes = ArrayList<Cliente>();

    fun agregarCliente(cliente : Cliente){

        this.clientes.add(cliente)
    }
}



