package backend.dao

import backend.modelo.Venta
import backend.service.runner.SessionFactoryProvider

class VentaDAO {
    fun getAllVentas(): Collection<Venta?>? {
        val session = SessionFactoryProvider.instance.createSession()
        val hql = ("from Venta v "
                + "order by v.id asc")
        val query = session!!.createQuery(hql, Venta::class.java)

        return query.getResultList()
    }


    fun guardar(venta: Venta) {
        val session = SessionFactoryProvider.instance.createSession()
        val tx = session!!.beginTransaction()
        session?.save(venta!!)
        tx!!.commit()
        session.close()
    }

}