package Frontend

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.core.util.RouteOverviewPlugin

fun main(args: Array<String>) {

    ApiFerreteria(7000).init()
}
class ApiFerreteria(private val  port:Int) {

    fun init(): Javalin {
        val app = Javalin.create {
            it.enableCorsForAllOrigins()
            it.registerPlugin(RouteOverviewPlugin("/routes"))

        }.exception(Exception::class.java) { e, ctx ->
            e.printStackTrace()
            ctx.status(500)
            ctx.json("Error fatal")
        }
                .start(port)
        val apiController = ControllerStock()

        app.routes {
            path("registrar") {
                post(apiController::crearCliente)
            }
            path("registrarProducto"){
                post(apiController::crearProducto)
            }
            path("/productos") {
                get(apiController::getProductos)
            }
        }
        return app
    }

}