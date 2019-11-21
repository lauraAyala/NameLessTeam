package backend.service

import backend.dao.ClienteDAO
import backend.modelo.Cliente
import backend.dao.DataDAO


class ClienteService(){
    private var clienteDAO = ClienteDAO()
    private val dataDAO: DataDAO? = null

    val allClientes: Collection<Cliente?>?
        get() = run { this.clienteDAO!!.getAll()}

    fun guardarCliente(cliente: Cliente) {
        run { this.clienteDAO!!.guardar(cliente) }
    }
}