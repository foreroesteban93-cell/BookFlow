
package com.example.bookflow.screens

import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import com.example.bookflow.model.Reservation

@Composable
fun RenewalSuccessScreen(
    reservation: Reservation,
    onReservations: () -> Unit
) {
    Page("¡Renovación exitosa! ✓") {
        Text("Libro: ${reservation.bookTitle}")
        Text("Nueva fecha: ${reservation.reservationDate}")
        Text("Estado: ${reservation.status}")

        PrimaryButton(
            text = "Volver a mis reservas",
            onClick = onReservations
        )
    }
}
