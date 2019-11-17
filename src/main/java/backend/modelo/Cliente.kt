package backend.modelo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Cliente(
        @Id
        @GeneratedValue
        val idCliente: Long? = null,
        val nombre : String,
        val apellido: String,
        val domicilio: String,
        val contacto: Int,
        val cuit: String,
        val esConsumidorFinal: Boolean,
        val esResponsableInscripto: Boolean) {
    constructor() : this(0,"","","",0,"",false,false) {

    }


}