
package com.example.bookflow.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bookflow.composables.Page
import com.example.bookflow.composables.PrimaryButton
import com.example.bookflow.model.Reservation

@Composable
fun ReservationSuccessScreen(
    reservation: Reservation,
    onHome: () -> Unit,
    onReservations: () -> Unit
) {
    Page("¡Reserva confirmada! ✓") {
        Text("Libro: ${reservation.bookTitle}")
        Text("Código: ${reservation.id}")
        Text("Fecha: ${reservation.reservationDate}")
        Text("Estado: ${reservation.status}")

        PrimaryButton("Volver al inicio", onHome)

        OutlinedButton(
            onClick = onReservations,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Consultar mis reservas")
        }
    }
}
