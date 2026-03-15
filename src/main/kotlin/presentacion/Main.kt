package org.practicatrim2.presentacion
import org.practicatrim2.datos.ReservaRepositoryMemoria
import org.practicatrim2.servicio.ReservaService

/**
 * Función que permite crear una reserva de vuelo o hotel.
 * Pide al usuario los datos necesarios y llama a ReservaService.
 */
fun crearReserva(servicio: ReservaService) {

    println("Tipo de reserva:")
    println("1. Vuelo")
    println("2. Hotel")
    print("Elige una opción: ")

    val tipo = readLine()!!.toInt()

    print("Descripción: ")
    val descripcion = readLine()!!

    if (tipo == 1) {

        print("Origen: ")
        val origen = readLine()!!

        print("Destino: ")
        val destino = readLine()!!

        print("Hora del vuelo (HH:mm): ")
        val hora = readLine()!!

        servicio.crearReservaVuelo(descripcion, origen, destino, hora)

        println("Reserva de vuelo creada")

    } else if (tipo == 2) {

        print("Ubicación: ")
        val ubicacion = readLine()!!

        print("Número de noches: ")
        val noches = readLine()!!.toInt()

        servicio.crearReservaHotel(descripcion, ubicacion, noches)

        println("Reserva de hotel creada")
    }
}

/**
 * Función que lista todas las reservas registradas.
 * Utiliza polimorfismo para mostrar el detalle específico de cada reserva.
 */
fun listarReservas(servicio: ReservaService) {

    val reservas = servicio.obtenerReservas()

    if (reservas.isEmpty()) {
        println("No hay reservas")
    } else {

        println("----- RESERVAS -----")

        for (reserva in reservas) {
            println(reserva.detalle)
        }
    }
}



/**
 * Punto de entrada del programa.
 * Muestra un menú en consola que permite:
 * 1. Crear reservas de vuelo o hotel
 * 2. Listar todas las reservas
 * 3. Salir del programa
 * Se comunica con ReservaService para gestionar la lógica de negocio.
 */
fun main() {

    val repositorio = ReservaRepositoryMemoria()
    val servicio = ReservaService(repositorio)

    var opcion: Int

    do {

        println("----- MENÚ -----")
        println("1. Crear reserva")
        println("2. Listar reservas")
        println("3. Salir")
        print("Elige una opción: ")

        opcion = readLine()!!.toInt()

        when (opcion) {

            1 -> crearReserva(servicio)

            2 -> listarReservas(servicio)

            3 -> println("Saliendo...")

            else -> println("Opción no válida")
        }

    } while (opcion != 3)
}


