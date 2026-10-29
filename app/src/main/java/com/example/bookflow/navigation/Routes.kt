
package com.example.bookflow.navigation

object Routes {
    const val HOME = "home"
    const val BOOKS = "books"
    const val BOOK_DETAIL = "book_detail/{bookId}"
    const val RESERVATION_SUCCESS =
        "reservation_success/{reservationId}"
    const val MY_RESERVATIONS = "my_reservations"
    const val RESERVATION_DETAIL =
        "reservation_detail/{reservationId}"
    const val RENEW_RESERVATION =
        "renew_reservation/{reservationId}"
    const val RENEWAL_SUCCESS =
        "renewal_success/{reservationId}"

    fun bookDetail(bookId: String) =
        "book_detail/$bookId"

    fun reservationSuccess(reservationId: String) =
        "reservation_success/$reservationId"

    fun reservationDetail(reservationId: String) =
        "reservation_detail/$reservationId"

    fun renewReservation(reservationId: String) =
        "renew_reservation/$reservationId"

    fun renewalSuccess(reservationId: String) =
        "renewal_success/$reservationId"
}
