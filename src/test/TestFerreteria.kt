import Backend.Cliente
import Backend.Ferreteria
import org.junit.jupiter.api.*
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)

class TestFerreteria {

    @Test
    fun test01VerificoQueElNombreDeLaFerreteriaEsteBien(){

       var ferreteria = Ferreteria("Stanley")

        assertEquals("Stanley",ferreteria.nombre,"es correcto")
    }

    @Test
    fun test02VerificoElNombreDeUnCliente(){

        var cliente = Cliente("Gerardo","Caseres","Las Rosas1432",45678903,"23456789459",true,false);

        assertEquals("Gerardo",cliente.nombre,"es correcto")
    }

    @Test
    fun test03VerificoElApellidoDeUnCliente(){

        var cliente = Cliente("Gerardo","Caseres","Las Rosas1432",45678903,"23456789459",true,false);

        assertEquals("Caseres",cliente.apellido,"es correcto")
    }

    @Test
    fun test04VerificoElDomicilioDeUnCliente(){

        var cliente = Cliente("Gerardo","Caseres","Las Rosas1432",45678903,"23456789459",true,false);

        assertEquals("Las Rosas1432",cliente.domicilio,"es correcto")
    }

    @Test
    fun test05VerificoElCuitDeUnCliente(){
        var cliente = Cliente("Gerardo","Caseres","Las Rosas1432",45678903,"23456789459",true,false);

        assertEquals("23456789459",cliente.cuit,"es correcto")
    }

    @Test
    fun test06VerificoSiUnClienteEsConsumidorfinal(){
        var cliente = Cliente("Gerardo","Caseres","Las Rosas1432",45678903,"23456789459",true,false);

        assertEquals(true,cliente.esConsumidorfinal,"es correcto")
    }

    @Test
    fun test07VerificoSiUnClienteEsResponsableInscripto(){
        var cliente = Cliente("Gerardo","Caseres","Las Rosas1432",45678903,"23456789459",true,false);

        assertEquals(false,cliente.esResponsableInscripto,"es correcto")
    }

    @Test
    fun test08agregoUnNuevoClienteEnLaFerreteriaYVerificoQueSeAgregoEseCliente(){
        var cliente = Cliente("Gerardo","Caseres","Las Rosas1432",45678903,"23456789459",true,false);
        var ferreteria = Ferreteria("Stanley")
        ferreteria.agregarCliente(cliente)

        assertEquals(true,ferreteria.clientes.contains(cliente),"es correcto")
    }


}