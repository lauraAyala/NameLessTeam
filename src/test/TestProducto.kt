import backend.modelo.Producto
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestMethodOrder
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)

class TestProducto{
    @Test
    fun testSeCreaUnProductoTornilloConDescuentoYPrecioDeCompra10ConPrecioDeVenta25(){
        var producto = Producto(1,"Tornillo de 2 pulgadas", 10.0,25.0,10)
        assertEquals(1,producto.idCodigo)
        assertEquals("Tornillo de 2 pulgadas", producto.descripcion)
        //assertEquals(true, producto.aplicaDescuento)
        //assertEquals(false, producto.aplicaPromo)
        assertEquals(10.0, producto.precioCompra)
        assertEquals(25.0,producto.precioVenta)
    }
}