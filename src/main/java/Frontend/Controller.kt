package Frontend

import Backend.Cliente
import Backend.Ferreteria
import io.javalin.http.Context
import io.javalin.http.Handler
import jdk.internal.org.objectweb.asm.Handle

class ControllerStock(){

    val ferreteria = Ferreteria("Bacco")

    fun crearCliente(ctx : Context){




        try{

            val cliente = Validar().validarCliente(ctx)
           // val cliente = ctx.bodyAsClass(ClienteView:: class .java)

            val clienteNuevo = Cliente(cliente.nombre,cliente.apellido,cliente.domicilio,cliente.contacto,cliente.cuit,cliente.esConsumidorfinal,cliente.esResponsableInscripto);

            ferreteria.agregarCliente(clienteNuevo);

            ctx.status(201)
            ctx.json(clienteNuevo)
        }
        catch(e: IllegalArgumentException){

            ctx.status(400)
        }


    }

}