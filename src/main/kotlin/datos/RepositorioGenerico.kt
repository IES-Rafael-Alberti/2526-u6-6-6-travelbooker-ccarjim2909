package org.practicatrim2.datos

class RepositorioGenerico<T> {
    private val elementos = mutableListOf<T>()
    fun agregar(elemento: T) { elementos.add(elemento) }
    fun obtenerTodos(): List<T> = elementos
}