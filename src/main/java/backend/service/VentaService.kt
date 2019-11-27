package backend.service
import backend.dao.VentaDAO
import backend.modelo.Venta

class VentaService {

    private var ventaDAO = VentaDAO()

    val allVentas: Collection<Venta?>?
        get() = run { this.ventaDAO!!.getAllVentas() }

    fun guardarVenta(venta: Venta) {
        run { this.ventaDAO!!.guardar(venta) }
    }

}