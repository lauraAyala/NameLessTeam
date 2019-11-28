package Frontend

import io.javalin.http.Context

class Validar {

    fun validarCliente(cxt: Context): ClienteView {
        var cliente = cxt.bodyValidator(ClienteView::class.java)
        .check({ it.nombre!!.isNotBlank() }, "El campo nombre no puede ser vacio ")
        .check({ it.nombre!!.matches(Regex("^[a-zA-Z*]*$")) }, "No ingreso un nombre correcto. Debe estar compuesto de letras ")
        .check({ it.apellido!!.isNotBlank() }, "El campo apellido no puede estar vacio ")
        .check({ it.apellido!!.matches(Regex("^[a-zA-Z*]*$")) }, "No ingreso un nombre correcto. Debe estar compuesto de letras  ")
        .check({ it.domicilio!!.isNotBlank() }, "domicilio no puede ser vacio ")
        .check({ it.contacto.toString().isNotBlank() }, "El campo contacto no puede estar vacio ")
        .check({ it.contacto.toString().matches(Regex("\\d*")) }, "El campo contacto tiene que estar compuesto por numeros sin guiones ")
        .check({ it.cuit.toString().isNotBlank() }, "El campo cuit no puede estar vacio ")
        .check({ it.cuit.toString().matches(Regex("\\d*")) }, "El campo cuit tiene que estar compuesto por numeros sin guiones ")
        .get()

        return cliente
    }

    fun validarProducto(ctx: Context): ProductoView {
        val producto = ctx.bodyValidator(ProductoView::class.java)
            .check({ it.idCodigo!!.toString().isNotBlank() }, "idCodigo no puede estar vacio ")
            .check({ it.idCodigo!!.toString().matches(Regex("\\d*")) }, "idCodigo no pueden ser letras, sino numeros")
            .check({ it.descripcion!!.isNotBlank() }, "descripcion no puede estar vacia")
            .check({ it.descripcion!!.matches(Regex("^[a-zA-Z*]*$")) }, "Descripcion debe tener un formato de letras")
            .check({ it.precioCompra!!.toString().isNotBlank() }, "precio de compra no puede ser vacio")
            .check({ it.precioVenta!!.toString().matches(Regex("\\d*")) }, "El precio de compra no pueden ser letras, sino un precio valido ")
            .check({ it.precioVenta!!.toString().isNotBlank() }, "precio de venta no puede ser vacio")
            .check({ it.precioVenta!!.toString().matches(Regex("\\d*")) }, "El precio de venta no pueden ser letras, sino un precio valido ")
            .check({ it.stock.toString().isNotBlank() }, "El campo stock no puede estar vacio ")
            .check({ it.stock.toString().matches(Regex("\\d*")) }, "El campo stock es invalido ")
            .get()

        return producto
    }

    fun validarVenta(ctx: Context): VentaView {
        val venta = ctx.bodyValidator(VentaView::class.java)
        .check({ it.idCodigo!!.toString().isNotBlank() }, "idCodigo no puede estar vacio ")
        .check({ it.idCodigo!!.toString().matches(Regex("\\d*")) }, "idCodigo no pueden ser letras, sino numeros ")
        .check({ it.clienteId!!.toString().matches(Regex("\\d*")) }, "CUIT cliente no pueden ser letras, sino numeros validos ")
        .check({ it.clienteId!!.toString().isNotBlank() }, "idCliente no puede ser vacio ")
        .check({ it.precioVenta!!.toString().isNotBlank() }, "precio de venta no puede ser vacio ")
        .check({ it.precioVenta!!.toString().matches(Regex("\\d*")) }, "El precio de venta no pueden ser letras, sino un precio valido ")
        .get()

        return venta
    }
}



