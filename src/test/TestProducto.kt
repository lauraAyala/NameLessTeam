import Backend.Producto
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestProducto{
    @Test
    fun testSeCreaUnProductoTornilloConDescuentoYPrecioDeCompra10ConPrecioDeVenta25(){
        var producto = Producto(1,"Tornillo de 2 pulgadas", true, false,10.0,25.0)
        assertEquals(1,producto.idCodigo)
        assertEquals("Tornillo de 2 pulgadas", producto.descripcion)
        assertEquals(true, producto.aplicaDescuento)
        assertEquals(false, producto.aplicaPromo)
        assertEquals(10.0, producto.precioCompra)
        assertEquals(25.0,producto.precioVenta)
    }
}