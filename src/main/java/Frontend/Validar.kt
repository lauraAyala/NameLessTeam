package Frontend

import Backend.Cliente
import io.javalin.http.Context
import io.javalin.http.Handler

class Validar {

    fun validarCliente(cxt: Context):ClienteView {
        val cliente = cxt.bodyValidator(ClienteView::class.java)
        try {

            cliente.check({ it.nombre!!.isNotBlank() }, "Name can't be empty ").get()
            cliente.check({ it.nombre!!.matches(Regex("^[a-zA-Z*]*$")) }, "The first name can only be composed of latters").get()
            cliente.check({ it.apellido!!.isNotBlank() }, "Lastname can't be empty ").get()
            cliente.check({ it.apellido!!.matches(Regex("^[a-zA-Z*]*$")) }, "The last name can only be composed of latters  ").get()
            cliente.check({ it.domicilio!!.isNotBlank() }, "domicilio no puede ser vacio").get()
            cliente.check({ it.cuit!!.isNotBlank() }, "cuit no puede ser vacio").get()
            cliente.check({ it.cuit!!.matches(Regex("^[0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}$")) }, "el cuit tiene que tener numeros positivos").get()
            cliente.check({ it.esConsumidorfinal!! == true ||  it.esConsumidorfinal == false }, "tiene que se un booleano").get()
            cliente.check({ (it.esResponsableInscripto!== true) ||  (it.esConsumidorfinal == false) }, "tiene que se un booleano").get()


        }catch (e:NoSuchElementException){
            cxt.status(400)
            //cxt.json(Handler(400, "Bad request", e.message!!))
        }catch (e:java.lang.Exception){
            cxt.status(400)
            //cxt.json(Handler(400, "Bad request", "Json keys must be firstName, lastName,password,idCard y email"))
        }
        return cliente.get()
    }
}