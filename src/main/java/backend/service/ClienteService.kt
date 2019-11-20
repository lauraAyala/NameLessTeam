package backend.service

import backend.dao.ClienteDAO
import backend.modelo.Cliente
import backend.dao.DataDAO


/*
class ClienteService(val clienteDao: ClienteDao, val dataDao: DataDao) {

    val allClientes: Collection<Cliente?>?
        get() = run { this.clienteDao.getAll()}

    fun guardarCliente(cliente: Cliente) {
        run { this.clienteDao.guardar(cliente) }
    }

    /*fun recuperarCliente(clienteId: Long?): Cliente {
        return run { this.clienteDao.recuperar(clienteId) }
    }*/

    fun clear() {
        run { this.dataDao.clear() }
    }


}*/

class ClienteService(){
    private val clienteDAO: ClienteDAO? = null
    private val dataDAO: DataDAO? = null

    val allClientes: Collection<Cliente?>?
        get() = run { this.clienteDAO!!.getAll()}

    fun guardarCliente(cliente: Cliente) {
        run { this.clienteDAO!!.guardar(cliente) }
    }
}