
package com.example.bookflow.model

data class Reservation(
    val id: String,
    val bookId: String,
    val bookTitle: String,
    val author: String,
    val reservationDate: String,
    val status: String = "Activa"
)

