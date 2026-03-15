package org.practicatrim2.datos
import org.practicatrim2.dominio.Reserva


/**
 * Implementación de IReservaRepository que guarda las reservas en memoria.
 * Utiliza una lista mutable para almacenar los objetos.
 */
class ReservaRepositoryMemoria : IReservaRepository {

    private val reservas = mutableListOf<Reserva>()

    override fun agregar(reserva: Reserva) {
        reservas.add(reserva)
    }

    override fun obtenerTodas(): List<Reserva> {
        return reservas
    }
}