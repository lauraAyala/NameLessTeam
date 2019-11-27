import backend.modelo.Cliente
import backend.modelo.Ferreteria
import backend.modelo.Producto
import org.junit.jupiter.api.*
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)

class TestFerreteria {

    @Test
    fun test01VerificoQueElNombreDeLaFerreteriaEsteBien() {

        var ferreteria = Ferreteria("Stanley")

        assertEquals("Stanley", ferreteria.nombre, "es correcto")
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

          assertEquals(true,cliente.esConsumidorFinal,"es correcto")
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

      @Test
      fun test09SeAgregaUnProductoALaFerreteria(){
          var producto = Producto(111,"Tornillo de 2 pulgadas",10.0,25.0,10)
          var ferreteria = Ferreteria("Stanley")
          ferreteria.agregarProducto(producto)

          assertEquals(1, ferreteria.productos.size)
          assertTrue(ferreteria.productos.contains(producto))
      }



    @Test
    fun test10QuieroRealizarUnaVenta() {
        var ferreteria = Ferreteria("Stanley");
        var cliente = Cliente("Jose", "Tornillo", "Calle falsa 123", 1143657100, "20-43657100-4", true, false);
        var producto = Producto(1, "Tornillo de 2 pulgadas", 10.0, 25.0, 1000);
        ferreteria.agregarCliente(cliente);
        ferreteria.agregarProducto(producto);
        // realizo la venta.
        ferreteria.realizarVenta(producto.idCodigo, cliente.cuit,producto.precioVenta, 500);

        assertEquals(500,ferreteria.stockActualDe(producto.idCodigo))

    }

    @Test
    fun test11QuieroSaberElStockDeUnProducto() {
        var ferreteria = Ferreteria("Stanley");
        var cliente = Cliente("Jose", "Tornillo", "Calle falsa 123", 1143657100, "20-43657100-4", true, false);
        var producto = Producto(1, "Tornillo de 2 pulgadas", 10.0, 25.0, 1000);
        ferreteria.agregarCliente(cliente);
        ferreteria.agregarProducto(producto);
        // verifico el stock actual
        ferreteria.stockActualDe(producto.idCodigo);

        assertEquals(1000,ferreteria.stockActualDe(producto.idCodigo))

    }

    @Test
    fun test12QuieroRealizarUnaVentaPeroNoTengoStock() {
        var ferreteria = Ferreteria("Stanley");
        var cliente = Cliente("Jose", "Tornillo", "Calle falsa 123", 1143657100, "20-43657100-4", true, false);
        var producto = Producto(1, "Tornillo de 2 pulgadas", 10.0, 25.0, 250);
        ferreteria.agregarCliente(cliente);
        ferreteria.agregarProducto(producto);
        // realizo la venta.
        assertFailsWith(Exception::class){
            ferreteria.realizarVenta(producto.idCodigo, cliente.cuit,producto.precioVenta, 500);
        }

    }

}