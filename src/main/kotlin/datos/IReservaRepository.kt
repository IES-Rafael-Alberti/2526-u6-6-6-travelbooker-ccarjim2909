package org.practicatrim2.datos
import org.practicatrim2.dominio.Reserva

/**
 * Interfaz que define las operaciones de un repositorio de reservas.
 * Métodos:
 * - agregar(reserva): agrega una reserva
 * - obtenerTodas(): devuelve todas las reservas
 */
interface IReservaRepository {

    fun agregar(reserva: Reserva)

    fun obtenerTodas(): List<Reserva>
}
