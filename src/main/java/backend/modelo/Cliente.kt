package backend.modelo

import javax.persistence.*


@Entity
@Table
class Cliente() {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    var id: Int? = null

    lateinit var nombre: String

    lateinit var apellido: String

    lateinit var domicilio: String

    var contacto: Int = 0

    lateinit var cuit: String

    var esConsumidorFinal: Boolean = false

    var esResponsableInscripto: Boolean = false

    constructor(nombre: String, apellido: String, domicilio: String, contacto: Int, cuit: String, esConsumidorFinal: Boolean, esResponsableInscripto: Boolean) : this() {
        this.nombre = nombre
        this.apellido = apellido
        this.domicilio = domicilio
        this.contacto = contacto
        this.cuit = cuit
        this.esConsumidorFinal = esConsumidorFinal
        this.esResponsableInscripto = esResponsableInscripto
    }



}