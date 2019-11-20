package backend.dao

import backend.service.runner.TransactionRunner
import java.io.Serializable


/*
class Dao<T>(private val entityType: Class<T>) {

    fun guardar(cliente: T) {
        val session = TransactionRunner.currentSession
        session?.save(cliente)
    }

    fun recuperar(id: Long?): T? {
        val session = TransactionRunner.currentSession
        return session?.get(entityType, id)
    }

}*/

class Dao<T>(private val entityType: Class<T>) {

    fun guardar(cliente: T) {
        val session = TransactionRunner.getCurrentSession()
        session?.save(cliente)
    }

    fun recuperar(id: Long?): T? {
        val session = TransactionRunner.getCurrentSession()
        return session?.get(entityType, id)
    }

}