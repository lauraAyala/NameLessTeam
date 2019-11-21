package backend.dao


import backend.modelo.Cliente
import backend.service.runner.SessionFactoryProvider

class ClienteDAO {
    fun getAll(): Collection<Cliente?>? {
        val session = SessionFactoryProvider.instance.createSession()
        val hql = ("from Cliente c "
                + "order by c.id asc")
        val query = session!!.createQuery(hql, Cliente::class.java)

        return query.getResultList()
    }


    fun guardar(cliente: Cliente) {
        val session = SessionFactoryProvider.instance.createSession()
        val tx = session!!.beginTransaction()
        session?.save(cliente!!)
        tx!!.commit()
        session.close()
    }

}