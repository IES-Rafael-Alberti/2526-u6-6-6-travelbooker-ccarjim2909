package org.practicatrim2.dominio



/**
 * Representa una reserva de vuelo, heredando de Reserva.
 * Añade propiedades propias: origen, destino y horaVuelo.
 * Contiene método estático creaInstancia para generar objetos.
 */
class ReservaVuelo private constructor(descripcion: String, val origen: String, val destino: String, val horaVuelo: String) : Reserva(descripcion) {

    override val detalle: String
        get() = "$id - $descripcion - $origen -> $destino [$horaVuelo]"

    override fun toString(): String {
        return """
            Reserva de Vuelo
            ID: $id
            Descripción: $descripcion
            Origen: $origen
            Destino: $destino
            Hora: $horaVuelo
            Fecha creación: $fechaCreacion
        """.trimIndent()
    }

    companion object {
        /**
         * Método de clase para crear una instancia de ReservaVuelo.
         * Valida que la hora tenga formato HH:mm antes de crear el objeto.
         */
        fun creaInstancia(descripcion: String, origen: String, destino: String, horaVuelo: String): ReservaVuelo {

            val regexHora = Regex("^([01]?[0-9]|2[0-3]):[0-5][0-9]$")

            require(regexHora.matches(horaVuelo)) {
                "Formato de hora inválido. Usa HH:mm"
            }

            return ReservaVuelo(descripcion, origen, destino, horaVuelo)
        }
    }
}