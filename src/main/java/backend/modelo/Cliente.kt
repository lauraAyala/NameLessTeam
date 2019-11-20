package backend.modelo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Id
@GeneratedValue
var idCliente: Long? = null
@Entity
class  Cliente(
        val nombre: String,
        val apellido: String,
        val domicilio: String,
        val contacto: Int,
        val cuit: Int,
        val esConsumidorFinal: Boolean,
        val esResponsableInscripto: Boolean) {


}