package backend


import backend.dao.ClienteDao
import backend.dao.DataDao
import backend.modelo.Cliente
import backend.service.ClienteService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class ClienteServiceTest {
    /*private var service: ClienteService? = null
    private var cliente: Cliente? = null

    @BeforeAll
    fun setUp() {
        service = ClienteService(ClienteDaoImpl(), DataDaoImpl())
        cliente = Cliente(1, "Maguin", "algo", "calle falsa", 123, "1456", true, false)
        service!!.guardarCliente(maguin!!)
    }

    @AfterAll
    fun cleanup() {
                    SessionFactoryProvider.destroy()
                    service!!.clear()
    }*/

    @Test
    fun test_get_all() {
        var service: ClienteService? = null
        var cliente: Cliente? = null
        service = ClienteService(ClienteDao(), DataDao())
        cliente = Cliente(1, "Willy", "Wonka", "calle falsa", 123, "1456", true, false)
        service!!.guardarCliente(cliente!!)



        val clientes: Collection<Cliente?>? = service!!.allClientes
        assertEquals(1, clientes!!.size)
    }



}