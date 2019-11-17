package backend.service

import backend.modelo.Cliente
import backend.dao.ClienteDao
import backend.dao.DataDao


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


}