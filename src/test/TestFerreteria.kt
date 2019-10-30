import org.junit.jupiter.api.*
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)

class TestFerreteria {

    @Test
    fun test01VerificoQueElNombreDeLaFerreteriaEsteBien(){

       var ferreteria = Ferreteria("Stanley")

       //assert(ferreteria.nombre == "Stanley" )
        assertEquals("Stanley",ferreteria.nombre,"es correcto")


    }
}