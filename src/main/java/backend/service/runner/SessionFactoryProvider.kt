package backend.service.runner


import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration

class SessionFactoryProvider private constructor() {

    private val sessionFactory: SessionFactory?

    init {
        val configuration = Configuration()
        configuration.configure("hibernate.cfg.xml")
        this.sessionFactory = configuration.buildSessionFactory()
    }

    fun createSession(): Session {
        return this.sessionFactory!!.openSession()
    }

    companion object {

        private var INSTANCE: SessionFactoryProvider? = null

        val instance: SessionFactoryProvider
            get() {
                if (INSTANCE == null) {
                    INSTANCE = SessionFactoryProvider()
                }
                return INSTANCE!!
            }

        fun destroy() {
            if (INSTANCE != null && INSTANCE!!.sessionFactory != null) {
                INSTANCE!!.sessionFactory!!.close()
            }
            INSTANCE = null
        }
    }


}