package backend.dao

import backend.modelo.Producto
import backend.service.runner.SessionFactoryProvider

class ProductoDAO {
    fun getAllProducts(): Collection<Producto?>? {
        val session = SessionFactoryProvider.instance.createSession()
        val hql = ("from Producto p "
                + "order by p.id asc")
        val query = session!!.createQuery(hql, Producto::class.java)

        return query.getResultList()
    }


    fun guardar(cliente: Producto) {
        val session = SessionFactoryProvider.instance.createSession()
        val tx = session!!.beginTransaction()
        session?.save(cliente!!)
        tx!!.commit()
        session.close()
    }

}