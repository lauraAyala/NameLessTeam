package backend.dao

import backend.service.runner.TransactionRunner

class DataDao {

    fun clear() {
        val session = TransactionRunner.currentSession
        val nombreDeTablas = session!!.createNativeQuery("show tables").resultList
        session?.createNativeQuery("SET FOREIGN_KEY_CHECKS=0;").executeUpdate()
        nombreDeTablas.forEach { tabla -> session?.createNativeQuery("truncate table $tabla")!!.executeUpdate() }
        session?.createNativeQuery("SET FOREIGN_KEY_CHECKS=1;")?.executeUpdate()
    }
}