package backend



import backend.dao.ClienteDAO
import backend.dao.DataDAO
import backend.modelo.Cliente
import backend.service.ClienteService
import backend.service.runner.SessionFactoryProvider
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test


class  ClienteServiceTest {
    private var service: ClienteService? = null
    private var cliente: Cliente? = null
/*
    @BeforeAll
    fun setUp() {
        service = ClienteService(ClienteDao(), DataDao())
        cliente = Cliente("Maguin", "Perez", "algo", 4521875, 123,  true, false)
        service!!.guardarCliente(cliente!!)
    }*/
/*
    @AfterAll
    fun cleanup() {
                    SessionFactoryProvider.destroy()
                    service!!.clear()
    }*/

    @Test
    fun test_get_all() {
        var service: ClienteService? = null
        var cliente: Cliente? = null
        service = ClienteService()
        cliente = Cliente("Willy", "Wonka", "calle falsa", 123, 1456, true, false)
        service!!.guardarCliente(cliente!!)



        val clientes: Collection<Cliente?>? = service!!.allClientes
        assertEquals(1, clientes!!.size)
    }



}