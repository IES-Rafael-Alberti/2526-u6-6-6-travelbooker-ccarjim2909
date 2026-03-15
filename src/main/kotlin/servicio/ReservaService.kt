package org.practicatrim2.servicio
import org.practicatrim2.datos.IReservaRepository
import org.practicatrim2.dominio.Reserva
import org.practicatrim2.dominio.ReservaHotel
import org.practicatrim2.dominio.ReservaVuelo


/**
 * Servicio que gestiona la lógica de negocio de las reservas.
 * Depende de la interfaz IReservaRepository (principio DIP).
 * Métodos:
 * - crearReservaVuelo: crea y guarda un vuelo
 * - crearReservaHotel: crea y guarda un hotel
 * - obtenerReservas: devuelve todas las reservas
 */
class ReservaService(private val repositorio: IReservaRepository) {

    fun crearReservaVuelo(descripcion: String, origen: String, destino: String, horaVuelo: String) {

        val reserva = ReservaVuelo.creaInstancia(descripcion, origen, destino, horaVuelo)

        repositorio.agregar(reserva)
    }

    fun crearReservaHotel(descripcion: String, ubicacion: String, numeroNoches: Int) {

        val reserva = ReservaHotel.creaInstancia(descripcion, ubicacion, numeroNoches)

        repositorio.agregar(reserva)
    }

    fun obtenerReservas(): List<Reserva> {
        return repositorio.obtenerTodas()
    }
}