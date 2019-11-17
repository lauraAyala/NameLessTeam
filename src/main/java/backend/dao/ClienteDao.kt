package backend.dao

import backend.modelo.Cliente
import backend.service.runner.TransactionRunner
import org.hibernate.Session;
import org.hibernate.query.Query;

class ClienteDao {
    fun getAll(): Collection<Cliente?>? {
        val session: Session = TransactionRunner.currentSession!!
        val hql = ("from cliente i "
                + "order by cliente.idCliente asc")
        val query: Query<Cliente> = session.createQuery(hql, Cliente::class.java)
        return query.getResultList()
    }

    fun guardar(cliente: Cliente) {
        val session = TransactionRunner.currentSession
        session?.save(cliente!!)
    }

}