
package com.example.bookflow.data

import androidx.compose.runtime.mutableStateListOf
import com.example.bookflow.model.Book
import com.example.bookflow.model.Reservation

object BookRepository {

    val books = listOf(
        Book(
            id = "1",
            title = "Clean Code",
            author = "Robert C. Martin",
            category = "Programación",
            description = "Aprende a escribir código limpio y fácil de mantener."
        ),
        Book(
            id = "2",
            title = "Kotlin para Android",
            author = "Antonio Leiva",
            category = "Desarrollo móvil",
            description = "Conceptos fundamentales de Kotlin y Android."
        ),
        Book(
            id = "3",
            title = "Refactoring",
            author = "Martin Fowler",
            category = "Ingeniería de software",
            description = "Técnicas para mejorar la estructura del código."
        ),
        Book(
            id = "4",
            title = "The Pragmatic Programmer",
            author = "David Thomas y Andrew Hunt",
            category = "Programación",
            description = "Buenas prácticas para desarrolladores de software."
        )
    )

    val reservations = mutableStateListOf<Reservation>()

    private var nextReservationNumber = 1

    fun getBook(id: String): Book? {
        return books.find { it.id == id }
    }

    fun getReservation(id: String): Reservation? {
        return reservations.find { it.id == id }
    }

    fun reserveBook(book: Book): Reservation {
        val reservation = Reservation(
            id = "RES-${nextReservationNumber++}",
            bookId = book.id,
            bookTitle = book.title,
            author = book.author,
            reservationDate = "15/11/2026"
        )

        reservations.add(reservation)
        return reservation
    }

    fun renewReservation(
        id: String,
        newDate: String
    ): Boolean {
        val index = reservations.indexOfFirst {
            it.id == id
        }

        if (index == -1) return false

        val current = reservations[index]

        if (current.status != "Activa") return false

        reservations[index] = current.copy(
            reservationDate = newDate
        )

        return true
    }

    fun cancelReservation(id: String): Boolean {
        val index = reservations.indexOfFirst {
            it.id == id
        }

        if (index == -1) return false

        val current = reservations[index]

        if (current.status != "Activa") return false

        reservations[index] = current.copy(
            status = "Cancelada"
        )

        return true
    }
}
