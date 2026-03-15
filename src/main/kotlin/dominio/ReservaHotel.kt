package org.practicatrim2.dominio




/**
 * Representa una reserva de hotel, heredando de Reserva.
 * Añade propiedades propias: ubicacion y numeroNoches.
 * Contiene método estático creaInstancia para generar objetos.
 */
class ReservaHotel private constructor(descripcion: String, val ubicacion: String, val numeroNoches: Int) : Reserva(descripcion) {

    override val detalle: String
        get() = "$id - $descripcion - $ubicacion ($numeroNoches noches)"

    override fun toString(): String {
        return """
            Reserva de Hotel
            ID: $id
            Descripción: $descripcion
            Ubicación: $ubicacion
            Noches: $numeroNoches
            Fecha creación: $fechaCreacion
        """.trimIndent()
    }



    companion object {
        /**
         * Método de clase para crear una instancia de ReservaHotel.
         * Valida que el número de noches sea mayor que 0.
         */
        fun creaInstancia(descripcion: String, ubicacion: String, numeroNoches: Int): ReservaHotel {

            require(numeroNoches > 0) {
                "El número de noches debe ser mayor que 0"
            }

            return ReservaHotel(descripcion, ubicacion, numeroNoches)
        }
    }
}