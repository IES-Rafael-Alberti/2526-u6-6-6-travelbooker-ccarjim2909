package org.practicatrim2.dominio

import java.time.LocalDateTime
import java.util.UUID



/**
 * Clase abstracta que representa una reserva genérica.
 * Contiene las propiedades comunes a todas las reservas:
 * id, fechaCreacion, descripcion y detalle.
 */
abstract class Reserva(val descripcion: String) {

    val id: String = UUID.randomUUID().toString()

    val fechaCreacion: LocalDateTime = LocalDateTime.now()

    open val detalle: String
        get() = "$id - $descripcion"
}